#!/usr/bin/env python
# coding: utf-8

# In[69]:


import os
import json
import matplotlib.pyplot as plt
import numpy as np


# In[70]:


path = "json1/" 
files= os.listdir(path) 


# In[71]:


count=0
x=[]
y=[]
body_0_y=[] 
body_3_y=[]
body_4_y=[]
body_6_y=[]  

frame_count= []
frame_height= 1920
frame_width =1080
main_role_x = frame_width/2 #圖片初始中點x


json_pre1=[]
json_pre2=[]


# In[72]:


# 取主角所有節點x的平均，避免第一筆資料就有問題
def average_x(jf):
    average= 0
    x_sum= 0
    count= 0
    for i in range (25):
        if jf[3* i]!= 0:
            print("x="+str(jf[3* i]))
            x_sum+= jf[3* i]
            count+=1
    print("x_sum_count = "+str(count))
    average/=count       
    return average  


# In[73]:


# 補足節點偵測遺失
def alg2(json_f, json_pre1, json_pre2):
    #print(json_f[1+3*6], json_pre1[1+ 3*6])
    
    for i in range(75):
        if json_f[i]== 0 :
            if json_pre1[i]!=0:
                json_f[i]= 2*json_pre1[i]- json_pre2[i]                               
   
        
    return  json_f


# In[74]:


# 找靠近主要角色的骨架
def alg1(size,jf,count) :
    temp= 0 
    near= 0
    
    for i in range(size):
       
        #near= 該骨架與main_role_x的距離
        #點1的數據不可以出問題
        near= abs(average_x(jf['people'][0]['pose_keypoints_2d'])-main_role_x) 
        
        if abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x )< near :          
            near= abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x)
            temp= i
    #print(jf['people'][temp]['pose_keypoints_2d'][1*6])
    #print(near)               
      
    return  jf['people'][temp]['pose_keypoints_2d']


# In[75]:


for file in files: 
    if not os.path.isdir(file): 
        with open(path+"/"+file , 'r') as reader:
            data = reader.read()         
            jf = json.loads(data)    
            #計算共有幾個人
            json_size= len(jf['people'])
            print("json_size="+str(json_size))
            
            if count==0 :  #第一筆資料，找最接近中心
                  
                json_f= alg1(json_size, jf,count)
                  
                main_role_x=  json_f[1*3] 
                  
                body_0_y.append(frame_height-json_f[1+3*0])
                  
                body_3_y.append(frame_height-json_f[1+3*3])
        
                body_4_y.append(frame_height-json_f[1+3*4])
         
                body_6_y.append(frame_height-json_f[1+3*6])  
                 
                json_pre1= json_f
                json_pre2= json_f
                
                print("main_role_x = "+str(main_role_x))
                  
                count+= 1 
                  
            else : #其他找最靠近main_role
               
                json_f= alg1(json_size, jf,count)                 
                  
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


# In[ ]:





# In[76]:


xmin = 0
ymin = 0
xmax = frame_width
ymax = frame_height

#Right elbow           
plt.plot(frame_count, body_3_y, 'b')  
plt.title('right elbow')
plt.show() 

#Left elbow
plt.plot(frame_count, body_6_y, 'b')  
plt.title('Left elbow')
plt.show() 

#right wrist 
plt.plot(frame_count, body_4_y, 'b')  
plt.title('right wrist')
plt.show() 

#nose
plt.plot(frame_count, body_0_y, 'b')  
plt.title('nose')    
plt.show() 


# In[ ]:




