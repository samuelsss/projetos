var uriSplit = function(entrada){
    var map = entrada.replace('#','').split("&");
    var obj = new Object;
    
    map.forEach(function(conj){
        var info = conj.split("=");
        obj[info[0]] = info[1];
    });
    
    return obj;
};



var uri = uriSplit(location.hash);
console.log(uri);