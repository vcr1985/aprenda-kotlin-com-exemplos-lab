/**
 * Desafio de Projeto - DIO: Abstraindo um domínio de formações educacionais com Kotlin.
 * Autor: [Vando Ramos]
 * Repositório base: https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos-lab
 */

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

/**
 * Representa um conteúdo educacional da formação.
 *
 * @property nome Nome do conteúdo (ex: "Introdução ao Kotlin")
 * @property duracao Duração em minutos (valor padrão: 60)
 */
data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60
)

/**
 * Representa um aluno participante da formação.
 *
 * @property nome Nome completo do aluno
 */
data class Aluno(
    val nome: String
)

/**
 * Representa uma formação (conjunto de conteúdos educacionais).
 *
 * @property nome Nome da formação (ex: "Formação Kotlin Developer")
 * @property nivel Nível da formação (BÁSICO, INTERMEDIÁRIO, AVANÇADO)
 * @property conteudos Lista de conteúdos pertencentes à formação
 */
data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {

    // Conjunto de alunos matriculados (Set evita duplicidade automaticamente)
    private val alunosMatriculados = mutableSetOf<Aluno>()

    /**
     * Matricula um aluno na formação.
     * Caso o aluno já esteja matriculado, não adiciona novamente.
     */
    fun matricular(aluno: Aluno) {
        if (alunosMatriculados.add(aluno)) {
            println("✅ Aluno ${aluno.nome} matriculado com sucesso na formação \"$nome\"!")
        } else {
            println("⚠️ O aluno ${aluno.nome} já está matriculado na formação \"$nome\".")
        }
    }

    /**
     * Exibe detalhes da formação, incluindo:
     * - Nome e nível
     * - Lista de conteúdos e duração total
     * - Alunos matriculados
     */
    fun exibirDetalhes() {
        println("\n📘 Formação: $nome")
        println("Nível: $nivel")
        println("\nConteúdos:")
        conteudos.forEach { println("- ${it.nome} (${it.duracao} min)") }

        val duracaoTotal = conteudos.sumOf { it.duracao }
        println("⏱️ Duração total: $duracaoTotal minutos")

        println("\nAlunos matriculados:")
        if (alunosMatriculados.isEmpty()) {
            println("Nenhum aluno matriculado ainda.")
        } else {
            alunosMatriculados.forEach { println("- ${it.nome}") }
        }
    }
}

/**
 * Função principal (ponto de entrada)
 * Cria exemplos de conteúdos, formação e realiza matrículas.
 */
fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Orientação a Objetos com Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Coleções e Funções de Extensão", 100)

    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2, conteudo3)
    )

    val aluno1 = Aluno("Maria Silva")
    val aluno2 = Aluno("João Pereira")
    val aluno3 = Aluno("Ana Souza")

    // Matrículas
    formacaoKotlin.matricular(aluno1)
    formacaoKotlin.matricular(aluno2)
    formacaoKotlin.matricular(aluno3)
    formacaoKotlin.matricular(aluno1) // Testando duplicidade

    // Exibe os detalhes da formação
    formacaoKotlin.exibirDetalhes()
}
