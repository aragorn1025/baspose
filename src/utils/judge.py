# -*- coding: utf-8 -*-
import numpy as np
"""90度"""
def shoot_judge1(knee_lowest, judge_standard_1, body_2_x, body_3_x, body_4_x,
                  body_2_y, body_3_y, body_4_y):    
    try:
        v32_x= body_2_x[knee_lowest]- body_3_x[knee_lowest]
        v32_y= body_2_y[knee_lowest]- body_3_y[knee_lowest]
        v34_x= body_4_x[knee_lowest]- body_3_x[knee_lowest]
        v34_y= body_4_y[knee_lowest]- body_3_y[knee_lowest]   
        #print(v32_x, v32_y, v34_x, v34_y)         
        Lx= np.sqrt(v32_x*v32_x+ v32_y*v32_y)
        Ly= np.sqrt(v34_x*v34_x+ v34_y*v34_y)
        #print(Lx, Ly)
        cos_angle=(v32_x* v34_x+ v32_y*v34_y)/(Lx*Ly)  
        #print(cos_angle)
        angle=np.arccos(cos_angle)
        judge_angle_1=angle*360/2/np.pi
        print(judge_angle_1)
    
        if 80< judge_angle_1 < 100 :
            judge_standard_1= 'perfect'  #姿勢不正確
            judge_comment_1='Your posture was perfect' 
        elif 70<judge_angle_1<80 or 100<judge_angle_1<110 :   
            judge_standard_1= 'great'  #正確
            judge_comment_1='Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point'
        elif 60<judge_angle_1<70 or 110<judge_angle_1<120 : 
            judge_standard_1= 'normal' 
            judge_comment_1='Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point'
        else :
            judge_standard_1= 'bad'
            judge_comment_1='Your hand and shoulder must reach aproximately 90 degree when your knee was at the lowest point'
        return  judge_angle_1 ,  judge_standard_1  ,  judge_comment_1 
    except:
        return  0, 0 ,0 
"""手打直"""
def shoot_judge2(hand_highest, judge_standard_2, body_2_x, body_3_x, body_4_x,
                  body_2_y, body_3_y, body_4_y):

    try:
        v32_x= body_2_x[hand_highest]- body_3_x[hand_highest]
        v32_y= body_2_y[hand_highest]- body_3_y[hand_highest]
        v34_x= body_4_x[hand_highest]- body_3_x[hand_highest]
        v34_y= body_4_y[hand_highest]- body_3_y[hand_highest]   
        #print(v32_x, v32_y, v34_x, v34_y)         
        Lx= np.sqrt(v32_x*v32_x+ v32_y*v32_y)
        Ly= np.sqrt(v34_x*v34_x+ v34_y*v34_y)
        #print(Lx, Ly)
        cos_angle=(v32_x* v34_x+ v32_y*v34_y)/(Lx*Ly)  
        #print(cos_angle)
        angle=np.arccos(cos_angle)
        judge_angle_2=angle*360/2/np.pi
        print(judge_angle_2)     
     
        if 170<judge_angle_2< 180:
            judge_standard_2='perfect' 
            judge_comment_2= 'Your posture was perfect'
        elif 150< judge_angle_2< 170:   
            judge_standard_2= 'good'   
            judge_comment_2= 'Your hand must remain straight when the ball break away from hand'
        elif 130<judge_angle_2< 150 :
            judge_standard_2= 'ok'
            judge_comment_2= 'Your hand must remain straight when the ball break away from hand'
        elif 110<judge_angle_2< 130:
            judge_standard_2= 'normal'
            judge_comment_2= 'Your hand must remain straight when the ball break away from hand'
        elif 90< judge_angle_2< 110:   
            judge_standard_2= 'bad'
            judge_comment_2= 'Your hand must remain straight when the ball break away from hand'
        else:
            judge_standard_2= 'terrible'
            judge_comment_2= 'Your hand must remain straight when the ball break away from hand'
       
        return  judge_angle_2,  judge_standard_2, judge_comment_2
    except:
        return  0, 0, 0
   
"""手下壓"""
def shoot_judge3(hand_highest, finger_12_x, finger_12_y, body_3_x, body_4_x, body_3_y, body_4_y):  
    try:
        v412_x= finger_12_x[hand_highest]- body_4_x[hand_highest]
        v412_y= finger_12_y[hand_highest]- body_4_y[hand_highest]
        v43_x= body_3_x[hand_highest]- body_4_x[hand_highest]
        v43_y= body_3_y[hand_highest]- body_4_y[hand_highest]
        
        Lx= np.sqrt(v412_x*v412_x+ v43_x*v43_x)
        
        Ly= np.sqrt(v43_x*v43_x+ v43_y*v43_y)
        
        cos_angle=(v412_x* v43_x+ v412_y*v43_y)/(Lx*Ly)
        
        angle=np.arccos(cos_angle)
        judge_angle_3=angle*360/2/np.pi
        print(judge_angle_3) 
        
        if judge_angle_3< 150:
            return 1        
        else:
            return 0    
    except:
       return 0
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
