// Databricks notebook source
// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/data/silver")

// COMMAND ----------

val path = "dbfs:/mnt/data/silver/dataset_real_state/"
val df = spark.read.format("delta").load(path)

// COMMAND ----------

display(df)

// COMMAND ----------

display(df.select("anuncio.*"))

// COMMAND ----------

display(
  df.select("anuncio.*", "anuncio.endereco.*")
  )

// COMMAND ----------

val detail_data = df.select("anuncio.*", "anuncio.endereco.*")

// COMMAND ----------

val df_silver = detail_data.drop("caracteristicas", "endereco")
display(df_silver)

// COMMAND ----------

val path = "dbfs:/mnt/data/gold/dataset_real_state/"
df_silver.write.format("delta").mode("overwrite").save(path)

// COMMAND ----------


