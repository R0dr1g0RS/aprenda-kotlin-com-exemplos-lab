// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val ID: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listarConteudos(){
        print("|")
        for (c in conteudos) {
            print(" ${c.nome} |")
        }
        println("")
    }
  
    fun removerMatricula(userName: String){
        var indice = 0
        var encontrou = false
        for (user in inscritos){
            if (user.nome == userName) encontrou = true else{}
            if (!encontrou) indice++ else {}
        }
        
        inscritos.removeAt(indice)
    }
    
    fun removerMatricula(userID: Int){
        var indice = 0
        var encontrou = false
        for (user in inscritos){
            if (user.ID == userID) encontrou = true else {}
            if (!encontrou) indice++ else {}
        }
        
        inscritos.removeAt(indice)
    }

    fun buscarInscrito(userName: String){
        for (user in inscritos){
            if (user.nome == userName) println("Usuário: ${user.nome} está inscrito nessa formação!") else {}
        }
    }
    fun buscarInscrito(userID: Int){
        for (user in inscritos){
            if (user.ID == userID) println("Usuário: ${user.nome} está inscrito nessa formação!") else {}
        }
    }
}

fun main() {

    val user1 = Usuario("Rodrigo", 1)
    val user2 = Usuario("Joao", 2)
    val user3 = Usuario("Alexia", 3)
    val conteudos = listOf<ConteudoEducacional>(ConteudoEducacional("Versionamento de Codigo", 120), 
                                                ConteudoEducacional("POO", 60), 
                                                ConteudoEducacional("Funções", 60)
                                               )
    val formacaoKotlin = Formacao("Kotlin", conteudos, Nivel.BASICO)
    formacaoKotlin.matricular(user1)
    formacaoKotlin.matricular(user2)
    formacaoKotlin.matricular(user3)
    
    formacaoKotlin.buscarInscrito("Joao")
    formacaoKotlin.listarConteudos()
    
}
