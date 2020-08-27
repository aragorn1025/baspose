# -*- coding: utf-8 -*-
    
import os
import json
#import matplotlib.pyplot as plt
import numpy as np
import math
import database_connect
from utils.body_25 import *
from utils.anomaly import ghost, ghost2, fill_lost, fill_lost_finger
from utils.judge import shoot_judge1, shoot_judge2, shoot_judge3
#from line import openpose_output_path, video_date, video_id, new_video_path

new_video_path, new_video_id, new_video_date= database_connect.new_video_id()
video_path= '/home/data/uploads/'+ new_video_path
video_date= new_video_date
video_id= new_video_id
openpose_output_path='/home/json_out/json'+ str(video_id)

path = openpose_output_path

files= os.listdir(path) 
count=0
original=[]
after_fill = []
x=[]
y=[]

body= list()
for i in range (0, 25):
    body.append(dict())
    body[i]["x"]= []
    body[i]["y"]= []

  
finger= list()
for i in range (0, 20):
    finger.append(dict())
    finger[i]["x"]= []
    finger[i]["y"]= []    
    
hand_angle=[]

frame_count= []
frame_height= 1080
main_role_x = 960 #畫面終點x 

min_num= 0 # 最低點圖片編號
max_num= 0 # 最高點圖片編號
 #判斷
judge_standard_1= ''
judge_angle_1= 0
judge_comment_1= ''

judge_standard_2= ''
judge_comment_2= ''
judge_angle_2= 0

 #judge_1_flag= False #90度
 #judge_2_flag= False #手臂打直

judge_3_flag= True #右腳在前
judge_comment_3= ''

json_pre1=[] #前一個
json_pre2=[] #前兩個


 #找手最高點的圖
def hand_high(json, num):
    max_y= 0
    max_num= 0
    for i in range(0, num):
        if json[i]> max_y:
            max_y= json[i]
            max_num= i 
    return max_num   

 #找膝蓋最低點的圖  
def knee_low(json, num):  
    min_y= 1000
    min_num=0
    for i in range(0, num):
        if json[i]< min_y:
            min_y= json[i]
            min_num= i 
    return min_num                       

def elbow_shoulder(shoulder, elbow, num) :
    elsh= 0
    for i in range(0, num-1):
        if abs(shoulder[i]-elbow[i])<2 :
            print(i)
            elsh= i 
            break       
    return elsh            
      
#右腳前左腳後    
def judge_3(right, left, count):
    for i in range(0, count):
        if right[i]< left[i]:
            judge_3_flag= False
#print(judge_3_flag)        
"""            
def angle_plot(count) :
    for i in range(0, count):
        v32_x= body_2_x[i]- body_3_x[i]
        v32_y= body_2_y[i]- body_3_y[i]
        v34_x= body_4_x[i]- body_3_x[i]
        v34_y= body_4_y[i]- body_3_y[i]   
   
        Lx= np.sqrt(v32_x*v32_x+ v32_y*v32_y)
        Ly= np.sqrt(v34_x*v34_x+ v34_y*v34_y)
        
        cos_angle=(v32_x* v34_x+ v32_y*v34_y)/(Lx*Ly)  
        
        angle=np.arccos(cos_angle)
        angle2=angle*360/2/np.pi
        hand_angle.append(angle2)
"""     
    
for file in files: 
    if not os.path.isdir(file): 
        with open(path+"/"+file , 'r') as reader:
            data = reader.read()         
            jf = json.loads(data)    
            #計算共有幾個人
            json_size= len(jf['people'])  
            # main_role position_x
            if json_size!= 0:             
                if count==0 :  #第一筆資料，找最接近中心  
                    json_people= ghost(json_size, jf, main_role_x)
                    json_finger= ghost2(json_size, jf, main_role_x)
                    
                    print(len(json_people))
                    print(len(json_finger))
                 
                    main_role_x=  json_people[1*3] 
                  
                    body[Nose]['y'].append(frame_height-json_people[1+3*0])
                  
                    body[RShoulder]['y'].append(frame_height-json_people[1+3*2])
                  
                    body[RShoulder]['x'].append(json_people[0+3*2])
                  
                    body[RElbow]['y'].append(frame_height-json_people[1+3*3])
                  
                    body[RElbow]['x'].append(json_people[0+3*3])
                  
                    body[RWrist]['y'].append(frame_height-json_people[1+3*4])
                  
                    body[RWrist]['x'].append(json_people[0+3*4])
                  
                    body[LElbow]['y'].append(frame_height-json_people[1+3*6])
                  
                    body[RKnee]['y'].append(frame_height-json_people[1+3*10])
                  
                    body[LKnee]['y'].append(frame_height-json_people[1+3*13])
                  
                    body[LSmallToe]['x'].append(json_people[0+3*20])
                  
                    body[RSmallToe]['x'].append(json_people[0+3*2])                    
                  
                    finger[12]['x'].append(json_finger[1+3*12]) 
                  
                    finger[12]['y'].append(json_finger[3*12]) 
                  
                    count+= 1                      
                  
                else : #其他找最靠近main_role
                    json_people= ghost(json_size, jf, main_role_x)  
                    json_finger= ghost2(json_size, jf, main_role_x)   
                  
                    body[Nose]['y'].append(frame_height-json_people[1+3*0])
                    
                    body[RShoulder]['y'].append(frame_height-json_people[1+3*2])
                    
                    body[RShoulder]['x'].append(json_people[0+3*2])
                    
                    body[RElbow]['y'].append(frame_height-json_people[1+3*3])
                    
                    body[RElbow]['x'].append(json_people[0+3*3])
                    
                    body[RWrist]['y'].append(frame_height-json_people[1+3*4])
                    
                    body[RWrist]['x'].append(json_people[0+3*4])
                    
                    body[LElbow]['y'].append(frame_height-json_people[1+3*6])
                    
                    body[RKnee]['y'].append(frame_height-json_people[1+3*10])
                    
                    body[LKnee]['y'].append(frame_height-json_people[1+3*13])
                    
                    body[LSmallToe]['x'].append(json_people[0+3*20])
                    
                    body[RSmallToe]['x'].append(json_people[0+3*2])
                  
                    #finger_12_x.append(json_finger[1+3*12])
                    #finger_12_y.append(json_finger[3*12])
                  
                    finger[12]['x'].append(json_finger[1+3*12]) 
                    finger[12]['y'].append(json_finger[3*12]) 
                  
                    main_role_x=  (main_role_x+ json_people[1*3] )/2
         
                    count+=1       
         
           
          
        frame_count.append(count)
              #for i in range(0, 24):
                #x.append(json_f[3*i])
          
              #for i in range(0, 24):
                #y.append(json_f[1+ 3*i])    

"""補點"""
body= fill_lost(body)
finger= fill_lost_finger(finger)


"""
#print(len(body_0_x))
#print(body_0_x)
#if len(body_0_x)==0 or len(body_2_x) or len(body_3_x) or len(body_4_x) or len(body_6_x) or len(body_10_x) or len(body_13_x) or len(body_20_x) or len(body_23_x) :  
    #error= True 
#print(error)   


knee_lowest= knee_low(body_10_y,count)
print(knee_lowest)  
judge_angle_1, judge_standard_1, judge_comment_1=shoot_judge1(knee_lowest, judge_standard_1, body_2_x, body_3_x, body_4_x,
                  body_2_y, body_3_y, body_4_y)
"""

el_sh= elbow_shoulder(body[RShoulder]['y'], body[RElbow]['y'], count)
print(el_sh)
judge_angle_1, judge_standard_1, judge_comment_1=shoot_judge1(el_sh, judge_standard_1, body[RShoulder]['x'], body[RElbow]['x'], body[RWrist]['x'],
                  body[RShoulder]['y'], body[RElbow]['y'], body[RWrist]['y'])      

hand_highest= hand_high(body[RShoulder]['y'], count)
print(hand_highest)       
judge_angle_2, judge_standard_2, judge_comment_2=shoot_judge2(hand_highest,judge_standard_2, body[RShoulder]['x'], body[RElbow]['x'], body[RWrist]['x'],
                  body[RShoulder]['y'], body[RElbow]['y'], body[RWrist]['y'])  

judge3= shoot_judge3(hand_highest, finger[12]['x'], finger[12]['y'], body[RElbow]['x'], body[RWrist]['x'], body[RElbow]['y'], body[RWrist]['y'])
print(judge3)

# print(type(video_id))
angle1= float(judge_angle_1)
angle2= float(judge_angle_2)

if math.isnan(judge_angle_1) or  math.isnan(judge_angle_2) or judge_angle_1==0 or judge_angle_2== 0:
    print("error")
    error= 1
    database_connect.error(video_id, error, new_video_path)


else  :
    error= 0
    print("Not error")
    angle1= float(judge_angle_1)
    print(angle1)
    angle2= float(judge_angle_2)
    print(angle2)
    database_connect.error(video_id, error, new_video_path)
    database_connect.update_shoot_before(video_id, angle1, judge_standard_1, judge_comment_1, new_video_path, video_date)
    database_connect.update_shoot_after(video_id, angle2, judge_standard_2, judge_comment_2, new_video_path, judge3, video_date)
   







   
