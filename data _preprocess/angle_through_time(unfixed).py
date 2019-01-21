# -*- coding: utf-8 -*-
"""
Created on Tue Jan 15 10:50:51 2019

@author: 曾義鈞
"""

import os
import json
import matplotlib.pyplot as plt
import math
import numpy as np
path = "json18/" 
files= os.listdir(path) 
s = []
count=0
frame=0
x=[]
y=[]
angle=[]     
frame_count= []

for file in files: 
     if not os.path.isdir(file): 
         with open(path+"/"+file , 'r') as reader:
           data = reader.read()         
           jf = json.loads(data)           
           json_f= jf['people'][0]['pose_keypoints_2d']
           
           count+=1
           
           vx32= json_f[3*2]-json_f[3*3]
           vy32= (720-json_f[1+3*2])-(720-json_f[1+3*3])
           vx34= json_f[3*4]-json_f[3*3]
           vy34= (720-json_f[1+3*4])-(720-json_f[1+3*3])
           
           v32= [vx32, vy32]
           v34= [vx34, vy34]
           
           #3-2 (x,y)=(json_f[3*2]-json_f[3*3], json_f[1+3*2]-json_f[1+3*3])
           #3-4 (x,y)=(json_f[3*4]-json_f[3*3], json_f[1+3*4]-json_f[1+3*3])
           if 1920-json_f[1+3*3]>= 1920-json_f[1+3*2] :
               angle_elbow= math.acos((np.dot(v32, v34))/(np.sqrt(np.square(v32).sum())*np.sqrt(np.square(v34).sum()) ))*180/ math.pi
               angle.append(angle_elbow)
               frame+=1
               frame_count.append(count)

plt.subplot(1,1,1)
plt.plot(frame_count,angle, 'r')
plt.title('angle')
plt.savefig('shoot18_angle.png')   
plt.show()
               
               
           
           

 
           
           
           
   
           