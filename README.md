# Java Tech Stack Lab

Java 技术栈学习练习项目 —— 基于 Spring Boot 2.7.18 的多模块 Maven 项目，涵盖 Java 语言特性、主流中间件集成、分布式系统及进阶实践。

## 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 1.8 | 运行环境 |
| Spring Boot | 2.7.18 | 基础框架 |
| Maven | 3.9.6 | 构建工具 (含 Maven Wrapper) |
| Thymeleaf + Bootstrap 5 | - | 前端页面 |
| Docker Compose | - | 中间件容器编排 |

## 模块一览

### Java 语言特性

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-java-basics` | 8081 | 集合、泛型、反射、注解、Stream API |
| `lab-java-concurrent` | 8082 | 线程池、CompletableFuture、锁机制、并发工具类 |
| `lab-java-jvm` | 8083 | JVM 调优、GC、类加载器、OOM 场景复现 |
| `lab-java-design-pattern` | 8084 | 单例、工厂、策略、观察者等设计模式 |

### 数据层

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-mysql` | 8090 | MySQL + MyBatis-Plus CRUD、分页、事务 |
| `lab-redis` | 8091 | Redis 缓存、分布式锁 (Redisson)、限流 |
| `lab-mongodb` | 8092 | MongoDB CRUD、聚合查询、GridFS |
| `lab-elasticsearch` | 8093 | ES 索引管理、全文搜索、聚合分析 |

### 消息队列

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-rabbitmq` | 8100 | 简单队列、工作队列、发布订阅、路由、Topic |
| `lab-kafka` | 8101 | 生产者/消费者、分区策略、消费者组 |

### 分布式

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-zookeeper` | 8110 | Zookeeper + Curator 分布式锁、配置中心 |
| `lab-netty` | 8111 | Netty TCP/UDP 服务端客户端、自定义协议 |
| `lab-spring-cloud` | 8112 | Nacos 注册/配置中心、Feign、Sentinel |

### 进阶

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-security` | 8120 | Spring Security 认证授权、JWT、OAuth2 |
| `lab-websocket` | 8121 | WebSocket 实时通信、聊天室、消息推送 |
| `lab-task-scheduling` | 8122 | Spring @Scheduled、Quartz 定时任务 |
| `lab-file-storage` | 8123 | MinIO 文件上传下载 |
| `lab-api-docs` | 8124 | Swagger / Knife4j 接口文档 |

### 监控

| 模块 | 端口 | 说明 |
|------|------|------|
| `lab-monitoring` | 8125 | Spring Boot Actuator + Prometheus + Grafana |

### 公共

| 模块 | 说明 |
|------|------|
| `lab-common` | 统一响应体 `R<T>`、全局异常处理、工具类 |

## 快速开始

### 1. 启动中间件 (按需)

```bash
cd docker

# 启动全部基础设施
docker compose up -d

# 或按需启动特定服务
docker compose up -d mysql redis

# 含监控栈 (Prometheus + Grafana)
docker compose --profile monitor up -d
```

**中间件端口速查：**

| 服务 | 端口 | 管理界面 |
|------|------|----------|
| MySQL | 3306 | - |
| Redis | 6379 | - |
| MongoDB | 27017 | - |
| Elasticsearch | 9200 | - |
| RabbitMQ | 5672 | http://localhost:15672 |
| Kafka | 9092 | - |
| Zookeeper | 2181 | - |
| MinIO | 9000 | http://localhost:9001 |
| Nacos | 8848 | http://localhost:8848/nacos |
| Prometheus | 9090 | http://localhost:9090 |
| Grafana | 3000 | http://localhost:3000 |

### 2. 运行模块

```bash
# 方式一：Maven 命令
cd lab-redis
mvn spring-boot:run

# 方式二：IDEA 直接运行各模块的 Application 类

# 方式三：项目根目录指定模块
mvn spring-boot:run -pl lab-redis
```

### 3. 访问页面

浏览器打开对应模块端口，例如：http://localhost:8091

## 项目结构

```
java-tech-stack-lab/
├── pom.xml                         # Parent POM
├── mvnw / mvnw.cmd                 # Maven Wrapper
│
├── lab-common/                     # 公共模块
│   └── src/main/java/
│       └── com/codeself/lab/common/
│           ├── result/             # 统一响应 R<T>、ResultCode
│           └── exception/          # BusinessException、GlobalExceptionHandler
│
├── lab-java-basics/                # Java 基础特性
├── lab-java-concurrent/            # 并发编程
├── lab-java-jvm/                   # JVM 调优
├── lab-java-design-pattern/        # 设计模式
│
├── lab-mysql/                      # MySQL + MyBatis-Plus
├── lab-redis/                      # Redis
├── lab-mongodb/                    # MongoDB
├── lab-elasticsearch/              # Elasticsearch
│
├── lab-rabbitmq/                   # RabbitMQ
├── lab-kafka/                      # Kafka
│
├── lab-zookeeper/                  # Zookeeper + Curator
├── lab-netty/                      # Netty
├── lab-spring-cloud/               # Spring Cloud (Nacos/Feign/Sentinel)
│
├── lab-security/                   # Spring Security + JWT
├── lab-websocket/                  # WebSocket
├── lab-task-scheduling/            # 定时任务
├── lab-file-storage/               # MinIO 文件存储
├── lab-api-docs/                   # API 文档
├── lab-monitoring/                 # 监控
│
└── docker/                         # Docker Compose 编排
    ├── docker-compose.yml
    └── services/
        ├── mysql/init.sql
        └── prometheus/prometheus.yml
```

## 模块开发规范

每个模块的标准结构：

```
lab-xxx/
├── pom.xml
└── src/main/
    ├── java/com/codeself/lab/xxx/
    │   ├── XxxApplication.java          # @SpringBootApplication 启动类
    │   ├── IndexController.java         # 首页控制器
    │   ├── config/                      # 配置类
    │   ├── controller/                  # REST / 页面控制器
    │   └── service/                     # 业务逻辑
    └── resources/
        ├── application.yml              # 模块配置
        └── templates/
            └── index.html               # Thymeleaf 首页
```

## License

[Apache License 2.0](LICENSE)
