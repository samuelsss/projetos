var teste = {
    nome : 'Maria',
    idade : 22,
    cargo : 'Diretor'
};
//console.log(teste);


var novoTeste = function(){
    this.nome = 'Maria';
    this.idade = 22;
    this.cargo = 'Diretor';
};
var testeOk = new novoTeste();
console.log(testeOk);

var testeMegaMaster = new Object();
testeMegaMaster.nome = 'Maria';
testeMegaMaster.idade = 22;
testeMegaMaster.cargo = 'Diretor';
console.log(testeMegaMaster);

var testeMegaMaster = new Object();
testeMegaMaster['nome'] = 'Maria';
testeMegaMaster['idade'] = 22;
testeMegaMaster['cargo'] = 'Diretor';
console.log(testeMegaMaster);