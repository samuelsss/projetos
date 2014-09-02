var prova = function(entrada){
    var map = entrada.replace(' \\"','*--*').replace('\\" ','*--*').split(" ");
    var obj = new Object;
    
    map.forEach(function(conj){
        var info = conj.split("=");
        
        var quebra = [].map.call(info[1].split('*--*'), function(a){
            return a.replace('"', '') + ' ';
        });
        
        var valor = '';
        quebra.forEach(function(b){
            valor += b;
        });
        
        obj[info[0]] = valor.trim();
    });
    
    return obj;
};

var resultado = prova("nome=Maria idade=22 cargo=Diretor");
console.log(resultado);

var resultado = prova('descricao="Maria \\"da\\" Silva" feminino=false empresa=Microsoft');
console.log(resultado);