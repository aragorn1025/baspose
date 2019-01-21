# -*- coding: utf-8 -*-
"""
Created on Tue Jan 15 10:50:51 2019

@author: 曾義鈞
"""

import os
import json
import matplotlib.pyplot as plt
import numpy as np
path = "json17/" 
files= os.listdir(path) 
s = []
count=0

x=[]
y=[]
body_3_y=[]
body_4_y=[]
body_6_y=[]
           
frame_count= []
for file in files: 
     if not os.path.isdir(file): 
         with open(path+"/"+file , 'r') as reader:
           data = reader.read()         
           jf = json.loads(data)           
           json_f= jf['people'][1]['pose_keypoints_2d']
           #比較開始的點，誰接近中心，
           count+=1         
                   
           body_3_y.append(720- json_f[1+3*3])
        
           body_4_y.append(720- json_f[1+3*4])
         
           body_6_y.append(720- json_f[1+3*6])
           
          
           
           frame_count.append(count)
           
           for i in range(0, 24):
                x.append(json_f[3*i])
          
           for i in range(0, 24):
                y.append(json_f[1+ 3*i])
           
           
           
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
  
plt.savefig('shoot17.png')      
plt.show()       
     
           
           
   
           