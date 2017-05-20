<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="../../static/easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="../../static/easyui/themes/icon.css">
    <link rel="stylesheet" href="../../static/bootstrap/css/bootstrap.css">
    <script src="../../static/jquery-3.2.0.js"></script>
    <script src="../../static/easyui/jquery.easyui.min.js"></script>
    <script src="../../static/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script src="../../static/bootstrap/js/bootstrap.js"></script>
</head>


<body>

<div id="tabs"
     class="easyui-tabs"
     fit="true"
     border="false"
     style="overflow: hidden;width: 100%;height: 100%">

    <!--存放订单的表格-->
    <table id="data_grid"
           style="margin: 0px; padding: 0px;width: 100%;height: 100%"
           fit="true">
        <!--表中的数据由JavaScript动态生成-->
    </table>
</div>

</body>


<script>
    $(function () {
        $("#data_grid").datagrid({
            url: '/OrderManage/getOrderList',
            striped: "true",
            pagination: 'true',
            pageSize: 10,
            pageList: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
            fit: true,
            fitColumns: true,
            nowrap: false,
            border: false,
            isField: 'id',
            sortName: 'id',
            sortOrder: 'asc',
            columns: [[{title: '编号', field: 'id', width: 100, sortable: 'true'},
                {title: '菜品名称', field: 'foodName', width: 100, sortable: 'true'},
                {title: '菜品数量', field: 'foodNumber', width: 100, sortable: 'true'},
                {title: '取餐时间', field: 'getFoodTime', width: 100, sortable: 'true'}]]
        });
    });
</script>


</html>


