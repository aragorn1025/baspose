# -*- coding: utf-8 -*-


import os 
import database_connect

database_rowcount= database_connect.row_count()

while 1 :
    if database_connect.row_count()> database_rowcount:
        print("new data")
        database_rowcount= database_connect.row_count()
        
        #new_video_path, new_video_id, new_video_date, new_video_type= database_connect.new_video_id()
        new_video_path, new_video_id, new_video_date= database_connect.new_video_id()
        new_video_type= int(new_video_path[0])
        print("type:"+str(new_video_type))
        print("path="+str(new_video_path))
        video_path= '/home/data/uploads/'+ new_video_path
        print(video_path)
        video_date= new_video_date
        print(video_date)
        video_id= new_video_id
        print(video_id)
        openpose_output_path='/home/json_out/json'+ str(video_id)
        print(openpose_output_path)
        #video_type= database_connect.pose_type()
        print(new_video_type)
        if new_video_type== 0 :
            print("shoot")
            os.chdir("../openpose")
            os.system("./build/examples/openpose/openpose.bin --video " +video_path+ " --write_json "+openpose_output_path+ " --render_pose 0 --display 0 --hand")
            os.chdir("/home/src")
            os.system("python3 test4.py")     
        
        elif new_video_type== 1:
            print("layup")
            os.chdir("/home/openpose")
            os.system("./build/examples/openpose/openpose.bin --video " +video_path+ " --write_json "+openpose_output_path+ " --render_pose 0 --display 0 --hand")
            os.chdir("/home/src")
            os.system("python layup_test2.py")    
        

