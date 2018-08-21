mybatis加载流程
1. mybatis核心配置文件：配置数据源，事物管理方式，指定sql映射文件、
基本设置（数据库中的数据和实体类属性映射关系...）、别名设置
2. 创建SqlSessionFactory，根据配置文件生成工厂对象，创建sqlSession
3. SqlSession接口，提供给开发人员一个操作数据库的接口
4. Executor：执行对数据库的具体操作
5. Mapped statement(底层封装类)。负责生成具体的SQL命令及对查询结果集封装