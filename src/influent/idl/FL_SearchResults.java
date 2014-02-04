/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package influent.idl;  
@SuppressWarnings("all")
/** The set of results from a single search call. Each item also has a score. */
@org.apache.avro.specific.AvroGenerated
public class FL_SearchResults extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"FL_SearchResults\",\"namespace\":\"influent.idl\",\"doc\":\"The set of results from a single search call. Each item also has a score.\",\"fields\":[{\"name\":\"total\",\"type\":\"long\",\"doc\":\"total number of results found\",\"default\":0},{\"name\":\"results\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_SearchResult\",\"fields\":[{\"name\":\"score\",\"type\":\"double\",\"doc\":\"search score\",\"default\":0},{\"name\":\"result\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Entity\",\"doc\":\"The nodes in the social, financial, communications or other graphs. May represent concrete individuals or organizations,\\r\\n\\t specific proxies such as accounts, or the implicit individuals or groups behind those other entities.\",\"fields\":[{\"name\":\"uid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"This uid must represent either (1) a globally unique identifier that can be used to retrieve data for an\\r\\n\\t\\t\\texplicit entity, or (2) encoded query information that can be used to find a set of associated record\\r\\n\\t\\t\\tnotionally representing an implicit entity (e.g. Loans&FirstName&LastName&Gender). Must not be used for\\r\\n\\t\\t\\tIDs that aren't globally unique.  For example, in Kiva, \\\"Lenders\\\" has a UID (\\\"L12345\\\") while \\\"Borrowers\\\"\\r\\n\\t\\t\\thave an encoded search in the Loans table for uid (\\\"B{loan:23456;name=Daniel}\\\").  The encoded information\\r\\n\\t\\t\\tis data layer-specific, may be different from entity to entity or data set to data set, and should be\\r\\n\\t\\t\\tconsidered opaque to the consumers of the entities.  Entities of type 2 should always have the Entity Tag\\r\\n\\t\\t\\tANONYMOUS to help distinguish them when required.\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_EntityTag\",\"doc\":\"This is the current list of tags for Entities:\",\"symbols\":[\"ACCOUNT\",\"GROUP\",\"CLUSTER\",\"FILE\",\"ANONYMOUS\",\"OTHER\"]}},\"doc\":\"Entity Tags (see above, e.g. \\\"ACCOUNT\\\")\"},{\"name\":\"provenance\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Provenance\",\"doc\":\"This is a placeholder for future modeling of provenance. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"uri\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Placeholder for now. Express provenance as a single URI.\"}]},\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[{\"type\":\"record\",\"name\":\"FL_Uncertainty\",\"doc\":\"This is a placeholder for future modeling of uncertainty. It is not a required field in any service calls.\",\"fields\":[{\"name\":\"confidence\",\"type\":\"double\",\"doc\":\"Placeholder for now. Express uncertainty as a single number from 0 to 1.\",\"default\":1}]},\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FL_Property\",\"doc\":\"Each property on an Entity or Link is a name-value pair, with data type information, as well as optional\\r\\n\\t provenance. Tags provide a way for the data provider to associate semantic annotations to each property\\r\\n\\t in terms of the semantics of the application.\",\"fields\":[{\"name\":\"key\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"the field name in the underlying data source\"},{\"name\":\"friendlyText\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"user-friendly short-text for key (displayable)\",\"default\":null},{\"name\":\"value\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"int\",\"float\",\"double\",\"long\",\"boolean\",{\"type\":\"record\",\"name\":\"FL_GeoData\",\"doc\":\"Structured representation of geo-spatial data.\",\"fields\":[{\"name\":\"text\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"an address or other place reference; unstructured text field\",\"default\":null},{\"name\":\"lat\",\"type\":[\"double\",\"null\"],\"doc\":\"latitude\",\"default\":null},{\"name\":\"lon\",\"type\":[\"double\",\"null\"],\"doc\":\"longitude\",\"default\":null},{\"name\":\"cc\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"ISO 3 digit country code\",\"default\":null}]},{\"type\":\"record\",\"name\":\"FL_Series\",\"doc\":\"This is a placeholder for timeseries and other series that are available as property values, which the UI will use to make\\r\\n\\t charts. This may come back from aggregating links.\",\"fields\":[]},\"null\"],\"default\":null},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"FL_PropertyType\",\"doc\":\"Allowed types for Property values.\",\"symbols\":[\"DOUBLE\",\"LONG\",\"BOOLEAN\",\"STRING\",\"DATE\",\"GEO\",\"SERIES\",\"OTHER\"]},\"doc\":\"One of DOUBLE, LONG, BOOLEAN, STRING, DATE, GEO, SERIES, OTHER\"},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_PropertyTag\",\"doc\":\"Tags are defined by the application layer as a taxonomy of user and application concepts,\\r\\n\\t independent of the data sources. This allows application semantics to be re-used with new\\r\\n\\t data, with a minimum of new software design and development. Data layer entity types, link\\r\\n\\t types and properties should be mapped into the list of tags. The application layer must be\\r\\n\\t able to search by native field name or by tag interchangeably, and properties returned must\\r\\n\\t contain both native field names as well as tags.\\r\\n\\t \\r\\n\\t The list of tags may change as application features evolve, though that will require\\r\\n\\t collaboration with the data layer providers. Evolving the tag list should not change the\\r\\n\\t Data Access or Search APIs.\\r\\n\\r\\n\\t This is the current list of tags for Properties:\",\"symbols\":[\"ID\",\"TYPE\",\"LABEL\",\"STAT\",\"TEXT\",\"LINKED_DATA\",\"IMAGE\",\"GEO\",\"DATE\",\"AMOUNT\",\"CREDIT\",\"DEBIT\",\"COUNT\",\"SERIES\",\"CONSTRUCTED\",\"RAW\"]}},\"doc\":\"one or more tags from the Tag list, used to map this source-specific field into the semantics of applications\"}]}}}]},{\"type\":\"record\",\"name\":\"FL_Link\",\"doc\":\"* The links in the social, financial, communications or other graphs. May represent communication events, financial transactions\\r\\n\\t * or social connections.\",\"fields\":[{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"enum\",\"name\":\"FL_LinkTag\",\"doc\":\"This is the current list of tags for Links:\",\"symbols\":[\"FINANCIAL\",\"SOCIAL\",\"COMMUNICATION\",\"OTHER\"]}},\"doc\":\"Link Tags (see above, e.g. \\\"FINANCIAL\\\")\"},{\"name\":\"source\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"source entity uid\",\"default\":null},{\"name\":\"target\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"doc\":\"target entity uid\",\"default\":null},{\"name\":\"directed\",\"type\":\"boolean\",\"doc\":\"true if directed, false if undirected\",\"default\":true},{\"name\":\"provenance\",\"type\":[\"FL_Provenance\",\"null\"],\"default\":null},{\"name\":\"uncertainty\",\"type\":[\"FL_Uncertainty\",\"null\"],\"default\":null},{\"name\":\"properties\",\"type\":{\"type\":\"array\",\"items\":\"FL_Property\"}}]}],\"doc\":\"search result\"}]}},\"doc\":\"array of Items (Entities or Links) with scores\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** total number of results found */
   private long total;
  /** array of Items (Entities or Links) with scores */
   private java.util.List<influent.idl.FL_SearchResult> results;

  /**
   * Default constructor.
   */
  public FL_SearchResults() {}

  /**
   * All-args constructor.
   */
  public FL_SearchResults(java.lang.Long total, java.util.List<influent.idl.FL_SearchResult> results) {
    this.total = total;
    this.results = results;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return total;
    case 1: return results;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: total = (java.lang.Long)value$; break;
    case 1: results = (java.util.List<influent.idl.FL_SearchResult>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'total' field.
   * total number of results found   */
  public java.lang.Long getTotal() {
    return total;
  }

  /**
   * Sets the value of the 'total' field.
   * total number of results found   * @param value the value to set.
   */
  public void setTotal(java.lang.Long value) {
    this.total = value;
  }

  /**
   * Gets the value of the 'results' field.
   * array of Items (Entities or Links) with scores   */
  public java.util.List<influent.idl.FL_SearchResult> getResults() {
    return results;
  }

  /**
   * Sets the value of the 'results' field.
   * array of Items (Entities or Links) with scores   * @param value the value to set.
   */
  public void setResults(java.util.List<influent.idl.FL_SearchResult> value) {
    this.results = value;
  }

  /** Creates a new FL_SearchResults RecordBuilder */
  public static influent.idl.FL_SearchResults.Builder newBuilder() {
    return new influent.idl.FL_SearchResults.Builder();
  }
  
  /** Creates a new FL_SearchResults RecordBuilder by copying an existing Builder */
  public static influent.idl.FL_SearchResults.Builder newBuilder(influent.idl.FL_SearchResults.Builder other) {
    return new influent.idl.FL_SearchResults.Builder(other);
  }
  
  /** Creates a new FL_SearchResults RecordBuilder by copying an existing FL_SearchResults instance */
  public static influent.idl.FL_SearchResults.Builder newBuilder(influent.idl.FL_SearchResults other) {
    return new influent.idl.FL_SearchResults.Builder(other);
  }
  
  /**
   * RecordBuilder for FL_SearchResults instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<FL_SearchResults>
    implements org.apache.avro.data.RecordBuilder<FL_SearchResults> {

    private long total;
    private java.util.List<influent.idl.FL_SearchResult> results;

    /** Creates a new Builder */
    private Builder() {
      super(influent.idl.FL_SearchResults.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(influent.idl.FL_SearchResults.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing FL_SearchResults instance */
    private Builder(influent.idl.FL_SearchResults other) {
            super(influent.idl.FL_SearchResults.SCHEMA$);
      if (isValidValue(fields()[0], other.total)) {
        this.total = data().deepCopy(fields()[0].schema(), other.total);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.results)) {
        this.results = data().deepCopy(fields()[1].schema(), other.results);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'total' field */
    public java.lang.Long getTotal() {
      return total;
    }
    
    /** Sets the value of the 'total' field */
    public influent.idl.FL_SearchResults.Builder setTotal(long value) {
      validate(fields()[0], value);
      this.total = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'total' field has been set */
    public boolean hasTotal() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'total' field */
    public influent.idl.FL_SearchResults.Builder clearTotal() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'results' field */
    public java.util.List<influent.idl.FL_SearchResult> getResults() {
      return results;
    }
    
    /** Sets the value of the 'results' field */
    public influent.idl.FL_SearchResults.Builder setResults(java.util.List<influent.idl.FL_SearchResult> value) {
      validate(fields()[1], value);
      this.results = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'results' field has been set */
    public boolean hasResults() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'results' field */
    public influent.idl.FL_SearchResults.Builder clearResults() {
      results = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    public FL_SearchResults build() {
      try {
        FL_SearchResults record = new FL_SearchResults();
        record.total = fieldSetFlags()[0] ? this.total : (java.lang.Long) defaultValue(fields()[0]);
        record.results = fieldSetFlags()[1] ? this.results : (java.util.List<influent.idl.FL_SearchResult>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}