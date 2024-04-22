// Databricks notebook source
// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/data/bronze")

// COMMAND ----------

val path = "dbfs:/mnt/data/bronze/dados_brutos_imoveis.json"
val data = spark.read.json(path)

// COMMAND ----------

display(data)

// COMMAND ----------

val anuncio_data = data.drop("imagens", "usuario")
display(anuncio_data)

// COMMAND ----------

import org.apache.spark.sql.functions.col

// COMMAND ----------

val df_silver = anuncio_data.withColumn("id", col("anuncio.id"))
display(df_silver)

// COMMAND ----------

val path = "dbfs:/mnt/data/silver/dataset_real_state"
df_silver.write.format("delta").mode(SaveMode.Overwrite).save(path)

// COMMAND ----------


