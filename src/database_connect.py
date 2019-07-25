import pymysql.cursors
import os
import numpy as np
def row_count():
    connection = pymysql.connect(host='140.115.51.181',
                                port=40136,
                                user = 'cilab',
                                password = 'cilabbaspose',
                                db = 'baspost',
                                charset = 'utf8mb4',
                                cursorclass = pymysql.cursors.DictCursor)

    try:
        with connection.cursor() as cursor:
            cursor= connection.cursor()
            cursor.execute("SELECT * FROM video ")
            connection.commit()
            return cursor.rowcount     
                   
    finally:
        connection.close()
def new_video_id():
    connection = pymysql.connect(host='140.115.51.181',
                                port=40136,
                                user = 'cilab',
                                password = 'cilabbaspose',
                                db = 'baspost',
                                charset = 'utf8mb4',
                                cursorclass = pymysql.cursors.DictCursor)    
    try:
        with connection.cursor() as cursor:
            cursor= connection.cursor()
            cursor.execute("SELECT * FROM video ")
            connection.commit()
            for row in cursor:
                video_path=row['path']
                video_id= row['id']
                video_date= row['date']
            return video_path, video_id, video_date
    finally:
        connection.close()
         
def update_shoot_after(id, angle, judge, comment, filename, wrist, date) :
    connection = pymysql.connect(host='140.115.51.181',
                                port=40136,
                                user = 'cilab',
                                password = 'cilabbaspose',
                                db = 'baspost',
                                charset = 'utf8mb4',
                                cursorclass = pymysql.cursors.DictCursor)  

    try:
        with connection.cursor() as cursor:
            cursor= connection.cursor()
            sql= "INSERT INTO shootAfter(id, angle, judge, comment, filename, wrist, date) VALUES (%s, %s, %s, %s, %s, %s, %s)"
            cursor.execute(sql,(id, angle, judge, comment, filename, wrist, date))
            connection.commit()            
    finally:
        connection.close()

def update_shoot_before(id, angle, judge, comment, filename, date) :
    connection = pymysql.connect(host='140.115.51.181',
                                port=40136,
                                user = 'cilab',
                                password = 'cilabbaspose',
                                db = 'baspost',
                                charset = 'utf8mb4',
                                cursorclass = pymysql.cursors.DictCursor)  

    try:
        with connection.cursor() as cursor:
            cursor= connection.cursor()
            sql= "INSERT INTO shootBefore(id, angle, judge, comment, filename, date) VALUES (%s, %s, %s, %s, %s, %s)"
            cursor.execute(sql,(id, angle, judge, comment, filename, date))
            connection.commit()          
    finally:
        connection.close()        

def error(id, error, filename) :
    connection = pymysql.connect(host='140.115.51.181',
                                port=40136,
                                user = 'cilab',
                                password = 'cilabbaspose',
                                db = 'baspost',
                                charset = 'utf8mb4',
                                cursorclass = pymysql.cursors.DictCursor)  

    try:
        with connection.cursor() as cursor:
            cursor= connection.cursor()
            sql= "INSERT INTO error(id, error, filename) VALUES (%s, %s, %s)"
            cursor.execute(sql,(id, error, filename))
            connection.commit()          
    finally:
        connection.close()
         
#json_count= json_count+1
#openpose_output_path='/home/json_out/json'+  str(video_id)
#os.chdir("openpose")
#os.system("./build/examples/openpose/openpose.bin --video " +video_path+ " --write_json "+openpose_output_path+ " --render_pose 0 --display 0")
#os.system("python test.py")
