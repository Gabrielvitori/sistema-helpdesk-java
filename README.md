🛠️ Sistema de Suporte TI (HelpDesk)
📌 Sobre o Projeto
Este é um protótipo de sistema desktop criado para otimizar a abertura de chamados técnicos em ambientes corporativos (como operações de Call Center). A aplicação visa reduzir o tempo de resposta do suporte, capturando automaticamente os dados da máquina do usuário e enviando a solicitação diretamente para o banco de dados da equipe de TI.

O projeto foi desenvolvido com foco na aplicação de boas práticas de Programação Orientada a Objetos (POO) e persistência de dados utilizando Java puro.

💻 Tecnologias e Ferramentas
Linguagem: Java

Gerenciador de Dependências: Maven

Interface Gráfica (GUI): Java Swing

Estilização de UI: FlatLaf (Look and Feel moderno e flat)

Banco de Dados: MySQL

Comunicação de Dados: JDBC (Java Database Connectivity)

⚙️ Arquitetura e Padrões de Projeto
O código foi refatorado para fugir do acoplamento e estruturado no padrão DAO, dividindo as responsabilidades em quatro camadas principais:

model: Classes de domínio que representam os dados do negócio.

connection: Classe ConnectionFactory utilizando o padrão Singleton simplificado para gerenciar a abertura e fechamento das conexões com o MySQL.

dao: Encapsulamento de toda a lógica de persistência e comandos SQL, isolando o banco de dados da interface do usuário.

application: Camada visual focada apenas em interagir com o usuário e repassar objetos para o DAO.

🚀 Funcionalidades Principais (Features)
Captura Automática de Host: Utilização da classe InetAddress para identificar e preencher automaticamente o nome da máquina na rede, evitando erros de digitação do usuário.

Interface Moderna: Substituição do tema nativo do Java pelo FlatLaf, entregando uma experiência visual alinhada aos sistemas operacionais atuais (Windows 11).

Persistência Segura: Uso de PreparedStatement nas transações com o banco para evitar vulnerabilidades como SQL Injection.
