### 1、游标

#### 	1.1 动态cursor 

​	在打开游标的时候动态传参方式

```plsql
 CURSOR cur_line_data(t_header_id IN NUMBER) IS
        SELECT l.* FROM cux_hzero_ws_asn_line_itf l WHERE 					l.header_id = t_header_id;
```

#### 	1.2 可更新游标

​	在定义游标时加上个for update  of  <Colum>字句，然后在update中用current of cursor 即可更新

```plsql
Declare
     Cursor c_salary  is
       Select salary 
		from auths
		where author_code <= ‘A0006’ FOR UPDATE OF salary;
Begin
     FOR r_salary in c_salary LOOP
       UPDATE auths SET salary = salary + 50 WHERE CURRENT OF c_salary;
     END LOOP;
     COMMIT;
End;

```

