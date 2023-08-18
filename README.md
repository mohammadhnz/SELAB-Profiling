# SELAB-Profiling

## تمرین اول
بعد از اینکه کامپیوتر رم پر کرد و سر io wait مجبور شدم ریستارت کنم از اول انجام تمرین را شروع کردم و شروع به پروفایل برنامه کردم:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/248ed832-0e79-48dd-b3d7-f32bced129e3)

به دلیل مشکلات رم و زمان، لوپ داخلی را کاهش میدهیم تا بتوانیم کار را انجام دهیم. لوپ داخلی را به 4000 کاهش میدهیم. و ورودی‌هارا 1, 1, 1 میدهیم. داریم:  
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/eaf0c417-41ab-4a5e-9a04-877bcb511eac)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/384a351e-9972-4977-a914-6e69673bf87e)
<br>
همانطور که در تصویر زیر مشاهده میکنید اغلب زمان صرف شده در متد temp میباشد:
<br>
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/c05a7c89-ea83-4cd4-89ac-24904616a08e)

![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/d9d61558-ee96-4e53-8141-b732a08ba7d5)
همانطور که در تصویر دوم مشاهده میکنید دلیل زمان زیاد، متد grow arraylist میباشد. در واقع چون این لیست به صورت داینامیک سایزش افزایش پیدا میکند، همواره برای allocate حافظه و مواردی از این قبلی زمان و cpu صرف میشود. در نتیجه تغییر زیر را انجام میدهیم:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/a88bdc16-dc04-4655-aaa3-81b1151fd7f8)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/89fb04de-af83-4248-8dc7-e7e76c95b69c)

در قدم بعدی به جای ArrayList از آرایه فیکس integer استفاده میکنیم. در نتیجه بدین شکل به نتیجه میرسیم:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/cd8e32ce-1684-41da-9e15-eb79b93f0e5e)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/c365378d-0996-48f0-859c-f78f53d7d546)




