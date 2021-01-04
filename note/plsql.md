### 1、游标

​	动态cursor （在打开游标的时候动态传参方式）

```plsql
 CURSOR cur_line_data(t_header_id IN NUMBER) IS
        SELECT l.* FROM cux_hzero_ws_asn_line_itf l WHERE 					l.header_id = t_header_id;
```