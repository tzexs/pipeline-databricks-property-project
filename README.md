# pipeline-databricks-property-project

This project is an example of how using data services on Azure.

Given a json containing real-state data as address, number of rooms on a property, square meter and so on. The treatment was to ingest this data using delta files, clean and treat data to be usable for BI purposes.

**Storage Account** is used to provide a Datalake using Medallion Architecture (Bronze, Silver and Gold layers).

**App Service** is used to authenticate connection between native Azure Resources (such as Storage Account and ADF) and Azure Databricks.

**Azure Databricks** is used to ingest, clean and treat the data on it's respectives layers: bronze, silver and gold. The programming language used is Scala.

**Azure Data Factory** is used to orchestrate the pipeline.


![Untitled-2024-04-22-1548](https://github.com/tzexs/pipeline-databricks-property-project/assets/102391213/f721ec3b-aff2-43fe-a326-6df019d862ae)
