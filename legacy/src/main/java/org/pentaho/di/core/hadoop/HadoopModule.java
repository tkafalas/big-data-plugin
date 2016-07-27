package org.pentaho.di.core.hadoop;

import org.pentaho.big.data.api.cluster.NamedCluster;
import org.pentaho.hadoop.shim.HadoopConfiguration;

public class HadoopModule {
  private NamedCluster namedCluster;
  private HadoopModuleType hadoopModuleType;
  private HadoopConfiguration hadoopConfiguration;

  public HadoopModule( NamedCluster namedCluster, HadoopModule.HadoopModuleType hadoopModuleType,
      HadoopConfiguration hadoopConfiguration ) {
    this.namedCluster = namedCluster;
    this.hadoopModuleType = hadoopModuleType;
    this.hadoopConfiguration = hadoopConfiguration;
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
