$.ajax("test/pathParameter/testOne.do", {
    type: "POST",
    data: {hello: "hello", world: "world"},
    success: function (result) {
        console.log(result);
    }
});
$.ajax("test/pathParameter/testOne.do", {
    type: "GET",
    data: {hello: "hello", world: "world"},
    success: function (result) {
        console.log(result);
    }
});
$.ajax("test/pathParameter/testOne.do", {
    type: "PUT",
    data: {hello: "hello", world: "world"},
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});
var resultData = {status: 1, data: "asdsa"};
console.log(JSON.stringify(resultData));
console.log(JSON.parse(JSON.stringify(resultData)));
var list = ["123", 123, "345"];
//不设置接收类型
$.ajax({
    url: "test/testTwo.do",
    type: "POST",
    data:resultData,
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});
//接收json数据
$.ajax({
    url: "test/testBody.do",
    type: "POST",
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    // dataType:"json",
    data:JSON.stringify(resultData),
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});

var user={user:"张三",pwd:[123,"Asd"]};
$.ajax({
    url: "test/testThree.do",
    type: "POST",
    contentType:"application/json",
    data:JSON.stringify(user),
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});

$.ajax({
    url: "test/testMap.do",
    type: "POST",
    contentType:"application/json",
    data:JSON.stringify(resultData),
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});
$.ajax({
    url: "test/testList.do",
    type: "POST",
    contentType:"application/json",
    data:JSON.stringify(list),
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});
$.ajax({
    url: "test/testDateTimeParam.do",
    type: "GET",
    data:{date:"2019-03-04 12:39:29"},
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});
$.ajax({
    url: "test/testDateParam.do",
    type: "GET",
    dataType:"json",
    data:{date:"2019-03-03"},
    success: function (result) {
        console.log(result);
    }, error: function (result) {
        console.log(result);
    }
});