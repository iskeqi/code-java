# 什么是 ElasticSearch

Elasticsearch 是一个分布式、RESTful 风格的搜索和数据分析引擎

## 正向索引和倒排索引

![image-20210922220315155](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922220230433.png)

文档：每一条数据就是一个文档

词条：对文档中的内容分词，得到的词语就是词条

正向索引：基于文档id创建索引，查询词条时必须先找到文档，然后判断是否包含词条

倒排索引：对文档内容分词，对词条创建索引，并记录词条所在文档的信息。查询时先根据词条查询得到文档id，然后得到文档

## 文档

![image-20210922220959533](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922220959533.png)

## 索引

![image-20210922221223987](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922221223987.png)

## 概念对比

![image-20210922221303147](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922221303147.png)

## 架构

![image-20210922221901991](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922221901991.png)

## 分词

![image-20210922230726778](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922230726778.png)

![image-20210922232121559](D:\KEQI\MyCode\code-java\066-elasticsearch\doc\images\image-20210922232121559.png)