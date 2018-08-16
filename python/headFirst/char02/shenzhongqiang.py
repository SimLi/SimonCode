# -*- coding: utf-8 -*-
"""
Created on Wed Dec  6 17:42:08 2017

@author: hz
"""

from selenium import webdriver
from datetime import date, time, datetime, timedelta
#browser = webdriver.Ie()
# browser = webdriver.Firefox()
browser = webdriver.Chrome()
def logon():
    username="sihanwang"
    passwd="060328"
#    browser = webdriver.Firefox()
#     browser.get('http://jw.shenzhong.net/SZ/Default.aspx')
    browser.get('http://jw.shenzhong.net/SZ/Login.aspx')

#    browser.implicitly_wait(10)
    elem=browser.find_element_by_id("TxtUserName")
    elem.send_keys(username)
    elem=browser.find_element_by_id("TxtPassWord")
    elem.send_keys(passwd)
    elem=browser.find_element_by_id("ImageButton1")
    elem.click()
#    browser.implicitly_wait(10)
    

    
def getAct():    
    #找到"活动查看"页面
#    browser.implicitly_wait(10)
    elemnew=browser.find_element_by_id("TreeView1t6")
    print(elemnew)
    elemnew.click()
#    browser.implicitly_wait(10)
#/SZ/SchoolActivity/ActivityView/ActivityViewList.aspx
    browser.get('http://jw.shenzhong.net/SZ/SchoolActivity/ActivityView/ActivityViewList.aspx')
#    browser.switch_to_window(browser.window_handles[-1])
    
#    browser.implicitly_wait(15)
    
    #javascript:__doPostBack('GvReport','Next$0')
    js="javascript:__doPostBack('GvReport','Next$0')"  
    browser.execute_script(js)  
    
#    browser.switch_to_window(browser.window_handles[-1])
    browser.implicitly_wait(3)
    elem=browser.find_element_by_id("CheckBoxList1_0")
    elem.click()
    elem=browser.find_element_by_id("Button3")
    elem.click()
def work():
#    logon()    
#    browser = webdriver.Firefox()
#    browser.implicitly_wait(10)
              al = browser.switch_to_alert()
              al.accept()
        

def runTask(func, day=0, hour=0, min=0, second=0):
    # Init time
    now = datetime.now()
    strnow = now.strftime('%Y-%m-%d %H:%M:%S')
    print("now:",strnow)
    # First next run time
    period = timedelta(days=day, hours=hour, minutes=min, seconds=second)
    next_time = now + period
    strnext_time = next_time.strftime('%Y-%m-%d %H:%M:%S')
    print("next run:",strnext_time)
#  while True:
    tries=0
    strnext_time="2017-12-10 10:00:00"
    while tries<10:
      # Get system current time
      
      iter_now = datetime.now()
      iter_now_time = iter_now.strftime('%Y-%m-%d %H:%M:%S')
#      print("now:",iter_now_time)
      if str(iter_now_time) >= str(strnext_time):
          # Get every start work time
          print("start work: %s" % iter_now_time)
          tries=tries+1
          # Call task func
          #func()
          try:

            func()
          except:
            print("model dialog exception handle")
        #else:
        #     if no exception,get here
          finally:
            print("dialog") 
            al = browser.switch_to_alert()
            al.accept()    
#          print("task done.")
          # Get next iteration time
    #      iter_time = iter_now + period
    #      strnext_time = iter_time.strftime('%Y-%m-%d %H:%M:%S')
          print("next_iter: %s.Tried %d times " % (strnext_time,tries) )
          # Continue next iteration
          continue


    try:
        al = browser.switch_to_alert()
        al.accept()
    
    except:
        print("model dialog 2 close exception handle")
    #else:
    # if no exception,get here
    finally:
        print("dialog22222")
        print("now:",iter_now_time) 


from selenium import webdriver
from datetime import date, time, datetime, timedelta   
import time as t
#def qiang():
times=1
while times<2:
    try:
#        logon()
#         browser = webdriver.Firefox()
        logon()
        getAct()     
        runTask(work, second=5)
        
        
        t.sleep(3)
    except :
#        getAct()
        print("browser exception handle")
    #else:
    # if no exception,get here
    finally:
        times+=1
#        browser = webdriver.Firefox()
#        logon()
        print("the  times : %d"% times)
        print("browser")

