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


<body >
<div class="div_Info">
<form action="/crm/icm/save">



    <span class="intyfont">理财类型</span>&nbsp;&nbsp;&nbsp;
    <select class="u1" name="income_type" id="income_type">
        <#list list as type>
            <option value="${type.id}">${type.type_name}</option>
        </#list>
    </select>
    <br/>
    <br/>
    <br/>

    <span class="intyfont">投资金额</span>&nbsp;&nbsp;&nbsp;<input class="u1" name="principal" id="principal" value="10000"></input>
    <br/>
    <br/>
    <br/>

    <span class="intyfont">投资天数</span>&nbsp;&nbsp;&nbsp;<input class="u1" name="day_nums" id="day_nums" value="30"></input>
    <br/>
    <br/>
    <br/>
    <span class="intyfont">年化收益率</span></span>&nbsp;&nbsp;&nbsp;<input class="u1" name="rate" id="rate" value="10.00"></input>
    <br/>
    <br/>
    <br/>
    <span class="intyfont">生息日期</span>&nbsp;&nbsp;&nbsp;<input class="u1" name="begin_date" id="begin_date" value="20180120"></input>
    <br/>
    <br/>
    <br/>
    <span class="intyfont">预期收益</span>&nbsp;&nbsp;&nbsp;<input class="u1" name="profit" id="profit" value="300.00"></input>
    <br/>
    <br/>
    <br/>
    <input type="button" name="submitBon" value="Enter" id="submitBon" class="button">
</form>
</div>

</body>

</html>

<script type="text/javascript">
    $(document).ready(function(){
        console.log("load success");
        $("#submitBon").bind("click",save);
    });


    //保存理财
    function save() {
        var url = '/crm/icm/save';
        // 理财类型
        var income_type =  $("#income_type").val();
        // 投资金额
        var principal = $("#principal").val();
        // 投资天数
        var day_nums =  $("#day_nums").val();
        //存款日期
        var begin_date =  $("#begin_date").val();
        //生息日期
        var value_date =  $("#begin_date").val();
        //年化收益率
        var rate =  $("#rate").val();
        //预期收益
        var profit = $("#profit").val();

        //投资人
        var  user_id = "0";

        console.log('income_type:%s',income_type);
        console.log('principal:%s',principal);
        console.log('day_nums:%s',day_nums);
        console.log('begin_date:%s',begin_date);
        console.log('value_date:%s',value_date);
        console.log('rate:%s',rate);
        console.log('%c profit:%s','font-size:50px;',profit);

        $.ajax(
                {
                    url: url,
                    data: {income_type: income_type, principal: principal,day_nums:day_nums,begin_date:begin_date,value_date:value_date,rate:rate,profit:profit,user_id:user_id},
                    type: 'get',
                    async:true,
                    success: function (data) {

                        console.log('data_retCode:%s',data.retCode);
                        if(data.retCode == 0){
                            Lobibox.notify('warning', {msg: data.msg});
                        }else if(data.retCode >= 65){
                            Lobibox.notify('warning', {msg: data.msg});
                        }else{
                            Lobibox.notify('error', {msg: data.msg});
                        }
                    }
                }
        )
    }

</script>