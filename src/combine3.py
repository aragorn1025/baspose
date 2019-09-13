# -*- coding: utf-8 -*-

import os 
import database_connect

database_rowcount = database_connect.row_count()

while True:
    if database_connect.row_count() <= database_rowcount:
        continue

    print("new data")
    database_rowcount = database_connect.row_count()
    video_path, video_id, video_date = database_connect.new_video_id()
    video_path = "/home/data/uploads/" + video_path
    print(video_path)
    print(video_date)
    print(video_id)
    
    openpose_output_path = "/home/json_out/json" + str(video_id)
    print(openpose_output_path)
    
    os.chdir("../../openpose")
    os.system("./build/examples/openpose/openpose.bin --video " + video_path + " --write_json " + openpose_output_path + " --render_pose 0 --display 0 --hand")
    os.chdir("../baspose/src")
    os.system("python3 test1.py")
