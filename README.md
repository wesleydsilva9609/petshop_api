# 🐾 Petshop API

**Petshop API** é uma aplicação desenvolvida para gerenciar o agendamento de visitas em uma clínica veterinária. O projeto foi dividido em etapas bem definidas, com foco em boas práticas de desenvolvimento e aprendizado de novas tecnologias.

## 🚀 Funcionalidades

- **CRUD de Tutores**: Cadastro, atualização, listagem e remoção de tutores.
- **CRUD de Pets**: Gerenciamento dos animais vinculados a um tutor.
- **Agendamento de Consultas**: 
  - Consultas podem ser agendadas somente entre **07:00 e 19:00** (horário de funcionamento da clínica).
  - Apenas **datas futuras** são permitidas para agendamento.
  - Cancelamentos só são aceitos com **mínimo de 24 horas de antecedência**.

## ✅ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **PostgreSQL**
- **Maven**
- **Docker** (primeiro contato com containers e criação de imagens)
- **Render** (primeiro deploy em nuvem)

## 📦 Deploy

O projeto foi containerizado com Docker e hospedado na plataforma Render, sendo minha primeira experiência com deploy em nuvem e ambientes Dockerizados.

## 🎯 Objetivos do Projeto

Este projeto teve como foco:

- Consolidar conhecimentos em Java e Spring Boot.
- Praticar a criação de APIs RESTful com boas validações de regras de negócio.
- Aprender e aplicar conceitos de **Docker** para criação e gerenciamento de containers.
- Realizar o **deploy em produção** pela primeira vez utilizando Render.

## 📝 Conclusão

O desenvolvimento da Petshop API foi uma experiência extremamente enriquecedora, onde pude aplicar diversos aprendizados teóricos na prática e ainda explorar novas ferramentas do ecossistema de desenvolvimento moderno.
