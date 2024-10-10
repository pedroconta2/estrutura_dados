package array

val listaAlunos = mutableListOf<String>()

val menu: String
    get() {
        return "--- Menu de Alunos ---" +
                "\n1. Adicionar Aluno" +
                "\n2. Remover Aluno" +
                "\n3. Visualizar Lista de Alunos" +
                "\n4. Verificar Aluno" +
                "\n0. Sair" +
                "\nEscolha uma das opções:"
    }


fun main(args: Array<String>) {
    var opc: Boolean = false;

    do {
        println(menu)
        val opMenu: Int = readln().toInt();

        when (opMenu) {
            1 -> adicionarLista(listaAlunos)
            2 -> removerAluno(listaAlunos)
            3 -> mostrarAlunos(listaAlunos)
            4 -> verificaAluno(listaAlunos)
        }

    } while (!opc)
}

fun adicionarLista(list: MutableList<String>) {
    println("Insira um novo aluno:")
    list.add(readln())
}

fun removerAluno(list: MutableList<String>) {
    println("Insira o aluno que deseja remover")
    val aluno = readln()
    list.remove(aluno)
}

fun mostrarAlunos(list: MutableList<String>) {
    println(list.toString())
}

fun verificaAluno(list: MutableList<String>) {
    println("Me diga qual aluno deseja encontrar:")
    val aluno = readln()

    if (list.contains(aluno)) {
        println("Aluno encontrado")
    } else {
        println("Aluno não encontrado")
    }
}
