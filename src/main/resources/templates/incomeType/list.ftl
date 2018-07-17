<table id="table-2">
    <thead>
    <th>序 号</th>
    <th>理财类型</th>
    <th>累计金额</th>
    <th>详情</th>
    </thead>

    <tbody>
        <#list list as type>
        <tr>
            <input type="hidden" value="${type.id}">
            <td>${type_index+1}</td>
            <td>${type.type_name} </td>
            <td><span class="money">10000</span> </td>
            <td><img src="/images/xq.ico"></td>
        </tr>
        </#list>
    </tbody>
</table>

<script type="text/javascript">
    $(document).ready(function(){
        listSelect();
    });

    //理财列表的选择事件
    function listSelect() {
        console.log('listSelect');
        $("tr").slice(1).click(function () {
            trEvent($(this));
        });
    }
    
    //单击行的处理方法
    function trEvent(obj) {

        var  current_type_id = $("#type_id").val();
        //类型id
        var type_id = obj.children()[0].value;

        console.log(current_type_id);

        //if(current_type_id == "" || current_type_id == type_id) {
            //obj.toggleClass("checkedTr");
            //obj.addClass("checkedTr");
            //$("p").removeClass("a").addclass("b");
            //clean();
       // }
        $("#type_id").val(type_id);
        //名称
        var typeName = obj.children("td")[1].innerText;
        $(".typeName").val(typeName);
        if (type_id!="") {
            foreachTr(type_id);
        }
    }
    //行的点击次数
    var m = new Map();

    function foreachTr(type_id) {

        if (m.get(type_id) == null) {
            m.set(type_id,1);
        }else{
            m.set(type_id,2);
        }

        if (m.get(type_id) >= 2) {
            clean();
        }

        $("tr").slice(1).each(function () {
            var t_id = $(this).children()[0].value;
            console.log("foreachTr"+t_id+"_"+type_id);
            if(t_id == type_id){
                $(this).toggleClass("checkedTr");
                //clean();
            }else{
                $(this).removeClass("checkedTr");
            }
        });
    }

</script>