# :smile_cat: Miau Matcher :smile_cat:
> API REST de CRUD para adoção de gatos de rua.

Por falta de políticas públicas efetivas, a população de animais domésticos em situação de vulnerabilidade tem números alarmantes no Brasil. Segundo o Instituto Pet Brasil, [o número mais que dobrou no intervalo entre os anos de 2018 e 2020](https://institutopetbrasil.com/fique-por-dentro/numero-de-animais-de-estimacao-em-situacao-de-vulnerabilidade-mais-do-que-dobra-em-dois-anos-aponta-pesquisa-do-ipb/). Naquela época, já eram cerca de 184.960 animais abandonados ou resgatados por maus-tratos por ONGs e grupos de proteção animal. Mais recentemente, durante a pandemia de COVID-19, [a ONG Ampara Animal afirma que houve cerca de 60% de aumento de abandono](https://exame.com/bussola/abandono-de-animais-aumentou-cerca-de-60-durante-a-pandemia/), durante 2020 e 2021.

Pensando nisso, desenvolvi este projeto de API REST para auxiliar Organizações Não Governamentais e protetores da causa animal, para que consigam cadastrar gatos abandonados ou resgatados e seus respectivos tutores para uma possível adoção.

![Ilustração: Mulher de olhos fechados e gato tricolor enconstam suas cabeças enquanto há corações ao redor. ](https://i.pinimg.com/564x/bf/2c/07/bf2c0742978c9ff4d3397ec000e38d18.jpg)

## :star: Features :star:
- [x] Cadastro de gatos no banco de dados com informações relevantes para que tutores possam conhecer os seus futuros bichinhos;
- [x] Configuração de segurança básica com conexão com banco de dados usando o basic authentication do Spring Security;
- [x] Dois perfis de usuário: user e admin;
- [x] Ao fazer o cadastro, o usuário poderá escolher um gato para adoção;
- [x] É possível usar os endpoints GET, POST, PUT e DELETE em todas as entidades;
- [x] É possível gatos pelo seu ID ou nome;
- [x] Documentação da API feita com Swagger disponível no arquivo [openapi.yaml](https://github.com/giorgiasantos/api-adocao-gatos/blob/main/openapi.yaml);
- [x] Collection do Postman disponível no arquivo [Miau Match.postman_collection.json](https://github.com/giorgiasantos/api-adocao-gatos/blob/main/Miau%20Match.postman_collection.json).
      
## :star: Ferramentas :star:
- JDK 11;
- Spring Framework;
- Spring Security;
- Docker;
- PostgreSQL Database;
- H2 Database;
- DBEaver;
- MapSctuct;
