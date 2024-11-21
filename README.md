# Projeto StylistPro

## Integrantes
Jaqueline Martins - RM551744 - DevOps & Cloud Computing <br>
Mariana Bastos    - RM97510  - Java Advanced <br>
Matheus Oliveira  - RM551155 - Mobile Development/Database <br>
Victor Freitas    - RM99982  - Advanced Business with C#/Quality Assurance<br>
Breno Giacoppini  - RM98695  - Artificial Intelligence <br>

## NOTAS DE ATUALIZAÇÃO - SPRINT 4
- Criação de página de geração de modelo utilizando Thymeleaf
   http://localhost:8080/stylishpro/modelos/gerarmodelo?
![image](https://github.com/user-attachments/assets/d18353b0-1a0e-486a-98db-52872f377538)

- Inclusão de Spring Security e criptografia de senhas no login e signup
   http://localhost:8080/stylishpro/clientes/adicionar
   http://localhost:8080/stylishpro/clientes/login
  
- Utilização do Spring Actuator para monitoramento
![image](https://github.com/user-attachments/assets/761b8838-4e50-4661-89d9-adbda5383872)

  



## PROPOSTA DE SOLUÇÃO
Com a chegada da pandemia, diversas empresas apresentaram grandes
dificuldades em se manterem competitivas e ativas em um mundo onde a
reinvenção se mostrou necessária para a sobrevivência no mercado. Porém, os
impactos da pandemia se mantiveram mesmo após seu término, ainda
causando dificuldades para diversas empresas se reerguerem financeiramente.<br>

No entanto, não somente a indústria sofreu mudanças, mas também a
sociedade como um todo. A mudança de perspectiva sobre valores e condutas
na sociedade está afetando diretamente as empresas envolvidas com moda e
roupas, requisitando uma reinvenção nessas marcas e lojas à nova realidade
proposta pela população, cuja necessidade de se reformular se torna
imprescindível para seu crescimento, adaptando seu negócio para os mais
diversos públicos e acompanhando as novas tendências.<br>

Como citado em uma matéria do portal de notícias CNN Brasil, “[...] a resposta
está na dificuldade em atender a demanda do consumidor brasileiro e de criar
raízes no mercado nacional.” e “[...] o especialista (Ulysses Reis) afirma que
ambas as empresas necessitavam de adequações às mudanças do mercado de
consumo, especialmente em termos de inovação.”<br>

Com essa necessidade em mente, nossa equipe propõe como solução a
ferramenta StylistPro, focada no segmento de varejo de roupas e moda,
visando o aprofundamento das necessidades do cliente, seus gostos e suas
perspectivas futuras sobre o mercado para obter insights no desenvolvimento
de novas peças a serem lançadas nas lojas. Isso será feito através de uma
inteligência artificial que, através dos dados obtidos pelas mais diversas
plataformas existentes como blogs, redes sociais e padrões de compra, assim
como a observação de grandes movimentos da moda, gerará imagens de peças
que estão e/ou serão tendência para o público-alvo, aumentando, assim, a
identificação do consumidor com a peça desenvolvida. Além disso, com o
crescimento da moda sustentável pelo mundo, também serão propostas
soluções visando a utilização de materiais não poluentes, contribuindo para um
desenvolvimento amigável ao planeta, estimulando a fixação de valores à
empresa que também ocasionarão em uma maior conexão entre o consumidor
e a empresa.<br>

Para uma maior personalização e fidelização, um sistema de recomendação
personalizado analisará as tendências de compra de cada um individualmente,
além de auxiliar o consumidor em sua jornada na compra de vestimentas que
aumentarão sua autoestima e satisfação com a plataforma e-commerce.

### Diagrama Entidade-Relacionamento
![image](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/3653c2ba-79b6-44c4-9f67-2372bd34cdec)


### Diagrama de Classes
![diagrama_classes_sprint2](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/00b00f4d-54c0-41e7-afde-15003e6921aa)

## Passo a passo para rodar a aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/Mari-Bastet/JAVACHALLENGEFINAL.git
    ```

2. Importe o projeto na IDE de sua preferência
   ![image](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/fbc29d9e-e3c6-462e-ac69-9dfbbf20821c)

3. Rode a Classe "ChallengeApplication.java"
![image](https://github.com/Mari-Bastet/JAVACHALLENGEFINAL/assets/82931897/2908161a-c66a-4491-9dae-ed100b67961e)

## Endpoints da API
Arquivo contendo todos os endpoints feitos e testados até o momento no Postman se encontram na pasta "Documentacao".<br>
__Também estão disponíveis pelo Swagger.__



- CLIENTES E COMPRAS <br>
 Método: GET <br>
 link: localhost:8080/clientes <br>
 Descrição: Retorna todos os clientes e suas respectivas compras (se houverem compras feitas). <br>

 - CLIENTE POR ID <br>
 Método: GET <br>
 link: localhost:8080/clientes/{id_cliente} <br>
 Descrição: Retorna o cliente de ID informado. <br>

- ADICIONAR CLIENTE <br>
 Método: POST <br>
 link: localhost:8080/clientes/adicionar <br>
 Modelo JSON: ``` {
    "nome":"Calma",
    "email":"tranquilo@email.com",
    "data_nascimento":"01/10/2003",
    "endereco":"Rua tranquilo"
} ``` <br>
 Descrição: Cadastro de cliente. <br>

- PRODUTOS POR COMPRA <br>
 Método: GET <br>
 link: localhost:8080/compras/prodCompra/{id_compra} <br>
 Descrição: Retorna todas as compras e seus respectivos produtos. <br>

 - PRODUTOS POR COMPRA <br>
 Método: GET <br>
 link: localhost:8080/feedbacks/{id_cliente} <br>
 Descrição: Retorna todos os feedbacks do cliente de ID informado. <br>

 - FILIAIS E COMPRAS <br>
 Método: GET <br>
 link: localhost:8080/filial/relatorios/compras} <br>
 Descrição: Retorna a quantidade de compras por filial. <br>
 
 
  
