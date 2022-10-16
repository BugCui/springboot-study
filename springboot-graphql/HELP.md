# 使用方式
* 项目启动
* 打开网址：http://localhost:8080/graphiql?path=/graphql
* 粘贴：

```
query {
  bookById(id: "book-1") {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```
* 运行


> 参考网址：https://www.graphql-java.com/tutorials/getting-started-with-spring-boot