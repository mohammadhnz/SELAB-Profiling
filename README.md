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

## تمرین دوم
برای این بخش از یک برنامه که وظیفه چاپ لوزی به شکل تو خالی و با ضخامت دلخواه دارد، استفاده میکنیم. در ادامه اسکرین شات کد‌های آن را قرار میدهیم، فقط یک موردی که من با intellj به مشکل خوردم در تنظیم Modules کد را در یک پروژه دیگه جایگذاری کردم در نتیجه.
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/de0f82fb-32c6-4002-aaf9-80df750df36e)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/c127fd49-405f-448c-b073-6cc33dd57f59)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/8bff7535-f03a-4287-9eec-e8568e1a7548)

حال در ادامه به آن ورودی لوزی به ارتفاع ۲۰۰۰ و عرض ۱۰ میدهیم و آن را پروفایل میکنیم:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/e8337ca5-13fd-45f3-8313-e9fc42ee9855)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/5f01a65c-5007-4357-9ccc-b3fcacf645e3)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/18148773-8acd-475e-a84e-8a7394e591d6)
همانطور که مشاهده میکنیم مقدار خوبی از منابع در متد create لوزی مصرف میشوند. برای این اتفاق یک تغییری میدهیم چون در این تابع عملیات I/O زیادی انجام شده و باتلنک اصلی این هست، کل خروجی را یک بار چاپ میکنیم. البته در نمودارها هم این مشهود هست که اغلب زمان به عملیات چاپ در خروجی صرف میشود. کد خروجی به این شکل میشود:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/63978413-a82d-4d22-9def-c20929522e9e)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/7f75fce4-212f-44ad-840e-01074b5fb5d1)

در قدم بعدی خروجی نمودارهارا نشان میدهیم:
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/165020e6-418f-4cec-bdcf-cef31ca17159)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/f0a4c84d-768a-4ed1-ab05-5e35a3fb880c)
![image](https://github.com/mohammadhnz/SELAB-Profiling/assets/59181719/bc3389d7-9b73-4902-a897-e98b22b3a8ca)

در نهایت حدودا نصف زمان قبلی زمان صرف میشود و در نتیجه این تغییرات باعث بهینه شدن کد میشوند.


