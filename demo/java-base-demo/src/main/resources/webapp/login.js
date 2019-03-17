function test(){
    var div=document.getElementsByTagName("div");
    var span=document.getElementsByTagName("span");
    span[0].innerText="123";
    div[0].innerHTML="<h1>test</h1>";
}