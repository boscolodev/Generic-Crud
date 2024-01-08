Projeto de Estudo com Generics em Java

Este projeto é um estudo que utiliza generics em Java para criar um CRUD básico com um método adicional. O projeto inclui um serviço genérico GenericService que fornece operações básicas de CRUD para qualquer entidade.
Estrutura do Projeto

O projeto segue a seguinte estrutura:

    GenericService: Interface que define as operações CRUD genéricas.
    DataBaseException: Classe de exceção personalizada para erros de banco de dados.
    MapperUtil: Classe utilitária para mapeamento de entidades.
    Outros componentes específicos do seu projeto, como entidades, repositórios, etc.

Funcionalidades
Operações CRUD

O GenericService fornece as seguintes operações CRUD genéricas:

    findById(ID id): Busca uma entidade por ID.
    delete(ID id): Exclui uma entidade por ID.
    save(T entity): Salva uma nova entidade.
    update(ID id, T entity): Atualiza uma entidade existente.
    findAll(Pageable pageable): Busca todas as entidades paginadas.

Método Adicional

Além das operações CRUD padrão, o GenericService também inclui um método adicional:

    beforeSave(): Método hook que pode ser sobrescrito para realizar ações antes de salvar uma entidade.

Execução do Projeto

Para executar este projeto localmente, siga os passos abaixo:

    Clone este repositório.
    Certifique-se de ter o Java JDK e o Maven instalados em sua máquina.
    Navegue até o diretório raiz do projeto.
    Execute o comando mvn clean install para compilar e empacotar o projeto.
    Execute o projeto de acordo com a estrutura específica do seu projeto.

Contribuição

Este projeto é apenas para fins de estudo, mas contribuições são bem-vindas. Se você deseja contribuir, por favor, siga as diretrizes de contribuição e envie suas solicitações de pull para revisão.
