var c, str;
var e = document.createEvent("MouseEvents");
e.initEvent("click", true, true);
function getResult(e) {
   return e.parentNode.parentNode.parentNode.children[1].value;
}
//单选
for (var i = 20; i < 80; i++) {
    str = "single_";
    c = document.getElementsByName(str + i);
    if (c[0] != undefined) {
        switch (getResult(c[0])) {
            case "A":
                c[0].dispatchEvent(e);
                c[0].checked = true;
                break;
            case "B":
                c[1].dispatchEvent(e);
                c[1].checked = true;
                break;
            case "C":
                c[2].dispatchEvent(e);
                c[2].checked = true;
                break;
            case "D":
                c[3].dispatchEvent(e);
                c[3].checked = true;
                break;
        }
    }
}
//多选题
for (var i = 80; i < 101; i++) {
    str = "multiple_";
    c = document.getElementsByName(str + i);
    if (c[0] != undefined) {
        var sp = getResult(c[0]).split("");
        for (var y = 0; y < sp.length; y++) {
            switch (sp[y]) {
                case "A":
                    c[0].dispatchEvent(e);
                    c[0].checked = true;
                    break;
                case "B":
                    c[1].dispatchEvent(e);
                    c[1].checked = true;
                    break;
                case "C":
                    c[2].dispatchEvent(e);
                    c[2].checked = true;
                    break;
                case "D":
                    c[3].dispatchEvent(e);
                    c[3].checked = true;
                    break;
                case "E":
                    c[4].dispatchEvent(e);
                    c[4].checked = true;
                    break;
                case "F":
                    c[5].dispatchEvent(e);
                    c[5].checked = true;
                    break;
            }
        }
    }
}
//判断题
for (var i = 1; i < 20; i++) {
    str = "judge_";
    c = document.getElementsByName(str + i);
    if (c[0] != undefined) {
        if (getResult(c[0]) == 1) {
            c[0].dispatchEvent(e);
            c[0].checked = true;
        } else {
            c[1].dispatchEvent(e);
            c[1].checked = true;
        }
    }
}