# -*- coding: utf-8 -*-
"""
Created on Tue Jan 15 10:50:51 2019

@author: 曾義鈞
"""

import os
import json
import matplotlib.pyplot as plt
import numpy as np
path = "json4/" 
files= os.listdir(path) 
count=0
x=[]
y=[]
body_0_y=[] 
body_3_y=[]
body_4_y=[]
body_6_y=[]  

frame_count= []
frame_height= 720
main_role_x = 540 #畫面終點x 


json_pre1=[] #前一個
json_pre2=[] #前兩個

# 取主角所有節點x的平均，避免只取一點資料而那點資料有問題
def average_x(jf):
    average= 0
    x_sum= 0
    count_x= 0
    for i in range (0, 25):
        if jf[3* i]!= 0:
            x_sum+= jf[3* i]
            count_x+=1
    print(count_x)
    average/=count_x     
    return average  

# 補足節點偵測遺失
def alg2(json_f, json_pre1, json_pre2):
    #print(json_f[1+3*6], json_pre1[1+ 3*6])
    
    for i in range(0, 75):
        if json_f[i]== 0 :
            if json_pre1[i]!=0:
                json_f[i]= 2*json_pre1[i]- json_pre2[i]                               
   
        
    return  json_f
      
        
# 找靠近主要腳色的骨架
def alg1(size, jf, json_pre1, json_pre2, count ) :
    temp= 0 
    near= 0
    
    for i in range(0, json_size):
       
       #near= 該骨架與main_role_x的距離
        # 點1的數據不可以出問題
        near= abs(average_x(jf['people'][0]['pose_keypoints_2d'])-main_role_x)         
        if abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x )< near :          
            near= abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x)
            temp= i
    #print(jf['people'][temp]['pose_keypoints_2d'][1*6])
    #print(near)               
            
   
      
    return  jf['people'][temp]['pose_keypoints_2d']
                

 
    
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
                  
                  json_f= alg1(json_size, jf, json_pre1, json_pre2, count)
                  
                  #print(json_pre1)
                  main_role_x=  json_f[1*3] 
                  
                  body_0_y.append(frame_height-json_f[1+3*0])
                  
                  body_3_y.append(frame_height-json_f[1+3*3])
        
                  body_4_y.append(frame_height-json_f[1+3*4])
         
                  body_6_y.append(frame_height-json_f[1+3*6])  
                 
                  json_pre1= json_f
                  json_pre2= json_f
                  #print(main_role_x) 
                  
                  count+= 1
                  
           
               
                  
             else : #其他找最靠近main_role
               
                  json_f= alg1(json_size, jf, json_pre1, json_pre2, count)                 
                  
                  json_f= alg2(json_f, json_pre1, json_pre2)
                  
                  
                  body_0_y.append(frame_height-json_f[1+3*0])
                  
                  body_3_y.append(frame_height-json_f[1+3*3])
                  
                  body_4_y.append(frame_height-json_f[1+3*4])
         
                  body_6_y.append(frame_height-json_f[1+3*6])
                  
                  
                  json_pre2= json_pre1
                  json_pre1= json_f
                  
                  
                                                                    
                            #print(json_pre1)
                  #print(json_pre2)
                  #print(jf['people'][temp]['pose_keypoints_2d'][1*3])
                  
                  main_role_x=  (main_role_x+ json_f[1*3] )/2
                  
         
                  count+=1 
           
          
           
          
             frame_count.append(count)
           
              #for i in range(0, 24):
                #x.append(json_f[3*i])
          
              #for i in range(0, 24):
                #y.append(json_f[1+ 3*i])
           
 #Right elbow           
plt.subplot(2,2,1)
plt.plot(frame_count, body_3_y, 'b', label= 'right elbow')  
plt.title('right elbow')
#Left elbow
plt.subplot(2,2,2)
plt.plot(frame_count, body_6_y, 'b')  
plt.title('Left elbow')
#right wrist 
plt.subplot(2,2,3)
plt.plot(frame_count, body_4_y, 'b')  
plt.title('right wrist')

plt.subplot(2,2,4)
plt.plot(frame_count, body_0_y, 'b')  
plt.title('nose')
  
plt.savefig('shoo3.png')      
plt.show()                 
       

           
           
   
           