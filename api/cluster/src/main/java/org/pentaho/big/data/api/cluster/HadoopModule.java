package org.pentaho.big.data.api.cluster;

public class HadoopModule {
  private NamedCluster namedCluster;
  private HadoopModuleType hadoopModuleType;
  
  public HadoopModule( NamedCluster namedCluster, HadoopModuleType hadoopModuleType ) {
    this.namedCluster = namedCluster;
    this.hadoopModuleType = hadoopModuleType; 
  }

  public NamedCluster getNamedCluster() {
    return namedCluster;
  }

  public HadoopModuleType getHadoopModuleType() {
    return hadoopModuleType;
  }

  public enum HadoopModuleType {
    HIVE, HBASE, IMPALA, CLOUDERA_IMPALA, PMR
  }
  
}
