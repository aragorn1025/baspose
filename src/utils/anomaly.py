# -*- coding: utf-8 -*-
"""
遺失節點補足
original:需要補足節點的節點lsit

"""
def fill_lose(original) :
    pre = 0
    follow = 0 
    adjust = original
    tmp = 0
    d = 0
    for i in range(len(original)):
        if(adjust[i]==0):
            pre = original[i-1]
            for j in range(i+1,len(original)):
                if(original[j]!=0):
                    follow = original[j] 
                    tmp = j
                    break
            d = (follow - pre)/(j - i +1)
            ct = 1
            for k in range(i,tmp):   
                adjust[k] = pre + (ct)*d
                ct+=1
    
    return adjust

"""去除幽靈骨架"""
""" people:一個frame出現的骨架數
    jf: 一個frame所有骨架的節點資訊 
"""
    
def ghost(people, jf, main_role_x):
    temp= 0 
    near= 0    
    for i in range(0, people):
       
        """點1的數據不可以出問題"""
        near= abs(average_x(jf['people'][0]['pose_keypoints_2d'])-main_role_x)         
        if abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x )< near :          
            near= abs(average_x(jf['people'][i]['pose_keypoints_2d'])-main_role_x)
            temp= i
    #print(jf['people'][temp]['pose_keypoints_2d'][1*6])
    #print(near) 
    return  jf['people'][temp]

"""找人物節點的x平均"""
def average_x(jf):
    average= 0
    x_sum= 0
    count_x= 0
    for i in range (0, 25):
        if jf[3* i]!= 0:
            x_sum+= jf[3* i]
            count_x+=1
    #print(count_x)
    average/=count_x     
    return average  