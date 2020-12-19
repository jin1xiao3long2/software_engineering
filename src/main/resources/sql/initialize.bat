net start mysql
mysql.exe -u root -p

CREATE DATABASE IF NOT EXISTS runoob;
use runoob;
set names utf8;
source /sql/create_db.sql;
source /sql/article.sql;
source /sql/disease.sql;
source /sql/doctor.sql;
source /sql/forum.sql;
source /sql/hostipal.sql;
source /sql/user.sql;
source /sql/reply.sql;
