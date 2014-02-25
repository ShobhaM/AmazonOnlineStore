AmazonOnlineStore
=================
database name:
use onlinedb;

+--------------------+
| Tables_in_onlinedb |
+--------------------+
| CartItem           |
| Product            |
| ShoppingCart       |
| User               |
+--------------------+



desc ShoppingCart
    -> ;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| cartId       | int(11)     | NO   | PRI | NULL    |       |
| userId       | int(11)     | NO   |     | NULL    |       |
| totalQty     | int(11)     | YES  |     | NULL    |       |
| totalAmt     | varchar(45) | YES  |     | NULL    |       |
| checkoutTime | varchar(45) | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+

desc  CartItem;
+--------+---------+------+-----+---------+-------+
| Field  | Type    | Null | Key | Default | Extra |
+--------+---------+------+-----+---------+-------+
| cartId | int(11) | NO   | PRI | NULL    |       |
| prodId | int(11) | NO   | PRI | 0       |       |
| qty    | int(11) | YES  |     | NULL    |       |
+--------+---------+------+-----+---------+-------+

desc User
    -> ;
+-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| id        | int(11)     | NO   | PRI | NULL    | auto_increment |
| fname     | varchar(45) | YES  |     | NULL    |                |
| lname     | varchar(45) | YES  |     | NULL    |                |
| email     | varchar(45) | NO   | PRI | NULL    |                |
| password  | varchar(45) | YES  |     | NULL    |                |
| lastlogin | varchar(45) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+



 desc product;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| id    | int(11)     | NO   | PRI | NULL    | auto_increment |
| name  | varchar(45) | YES  |     | NULL    |                |
| desc  | varchar(45) | YES  |     | NULL    |                |
| price | varchar(45) | YES  |     | NULL    |                |
| qty   | varchar(45) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+








