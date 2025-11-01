# 💻 Desafio DIO - Abstraindo um Domínio em Kotlin

Este projeto faz parte do desafio proposto pela [Digital Innovation One (DIO)](https://www.dio.me/) para colocar em prática os conceitos fundamentais de **Programação Orientada a Objetos (POO)** utilizando **Kotlin**.  

O objetivo é **abstrair um domínio de formações educacionais** da DIO, criando um pequeno sistema que representa **formações, conteúdos e alunos matriculados**.

---

## 🧠 Objetivo do Desafio

Criar uma aplicação simples em Kotlin capaz de modelar o seguinte domínio:

- A DIO possui **Formações** com **níveis** (básico, intermediário, avançado);
- Cada Formação possui **Conteúdos Educacionais** com nome e duração;
- Uma Formação pode **matricular alunos**;
- O sistema deve permitir **listar alunos e conteúdos** de cada formação.

---

## 🧩 Estrutura do Domínio

```mermaid
classDiagram
    class ConteudoEducacional {
        +String nome
        +Int duracao
    }

    class Aluno {
        +String nome
    }

    class Formacao {
        +String nome
        +Nivel nivel
        +List~ConteudoEducacional~ conteudos
        +Set~Aluno~ alunosMatriculados
        +matricular(aluno: Aluno)
        +exibirDetalhes()
    }

    class Nivel {
        <<enumeration>>
        BASICO
        INTERMEDIARIO
        AVANCADO
    }

    Formacao "1" --> "*" ConteudoEducacional
    Formacao "1" --> "*" Aluno
