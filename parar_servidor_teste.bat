@echo off
for /f "tokens=5" %%A in ('netstat -aon ^| findstr :9001') do  taskkill /F /PID %%A 
exit /b 0



