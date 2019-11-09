<html lang="en">
<link href="/css/style.css" rel='stylesheet' type='text/css' />

<link rel="stylesheet" href="/css/bootstrap.css"/>
<link rel="stylesheet" href="/css/systemMessage/demo/demo.css"/>
<link rel="stylesheet" type="text/css" href="/css/systemMessage/css/default.css">
<link rel="stylesheet" href="/css/systemMessage/dist/css/Lobibox.min.css"/>


<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script src="/js/lib/jquery.1.11.min.js"></script>
<script src="/js/dist/js/lobibox.js"></script>
<script src="/js/demo/demo.js"></script>



<script type="text/javascript">


    $(document).ready(function(){
        $("#submitBon").bind("click",save);
        $("#deleteBon").bind("click",del);
       // alert('test');
        //加载理财类型列表;
        loadList();
    });


    //保存理财类型
    function save() {
        var url = '/crm/incomeType/save';
        var id =  $("#type_id").val();
        var type_name = $(".typeName").val();
        $.ajax(
                {
                    url: url,
                    data: {id: id, type_name: type_name},
                    type: 'get',
                    async:true,
                    success: function (data) {
                        if(data.retCode == 0){
                            loadList();
                            clean()
                        }else if(data.retCode >= 65){
                            Lobibox.notify('warning', {msg: data.msg});
                        }else{
                            Lobibox.notify('error', {msg: data.msg});
                        }
                    }
                }
        )
    }

    //清空参数
    function clean() {
        $(".typeName").val("");
        $("#type_id").val("");
        m = new Map();
    }
    //保存理财类型
    function del() {
        var url = '/crm/incomeType/del';
        var id =  $("#type_id").val();
        $.ajax(
                {
                    url: url,
                    data: {id: id},
                    type: 'get',
                    async:true,
                    success: function (data) {
                        if(data.retCode == 0){
                            loadList();
                            clean();
                        }else{
                            Lobibox.notify('error', {msg: data.msg});
                        }
                    }
                }
        )
    }



    //加载理财类型列表
    function loadList(){
        //alert('loadList');
        $.get("/crm/incomeType/query", function(data){
            //alert(data);
            $("#incomeList").html(data);
        });
    }

</script>


<body >

<form action="/crm/incomeType/save">
    <div class="div">
    <input type="text" name="type_name" class="typeName">&nbsp;&nbsp;&nbsp;
    <input type="button" name="submitBon" value="Enter" id="submitBon" class="button">&nbsp;&nbsp;&nbsp;
    <input type="button" name="deleteBon" value="Delete" id="deleteBon" class="button">
        <input type="hidden" name="id" id="type_id">
    </div>
</form>

<#--理财类型列表-->
<div class="div_table" id="incomeList">

</div>

</body>

</html>

