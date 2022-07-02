import smtplib
from email.mime.text import MIMEText

from email.mime.multipart import MIMEMultipart
import sys


def send_email(sender, reciever, message, subject):
    server = smtplib.SMTP(host='smtp.gmail.com', port=587)
    server.starttls()
    server.login("eventx.ex@gmail.com", "dlwnhhozypyfyvha")
    print('Logged into the server')

    msg = MIMEMultipart()
    msg['To'] = reciever
    msg['From'] = sender
    msg['Subject'] = subject

    msg.attach(MIMEText(message, 'plain'))
    server.send_message(msg)
    print("Email sent successfully")
    del msg

args = sys.argv[1:]

#0-> receiver
#1-> message
#2-> subject

message ="Please use this code to verify the email-Id linked with EventX account :: "+args[0]+" \n\nHere is your verication code :: "+args[1]+"\n\nThanks, \nTeam EventX."
send_email("testmycode155@gmail.com",args[0],message,args[2]+" "+args[3]+" "+args[4])

