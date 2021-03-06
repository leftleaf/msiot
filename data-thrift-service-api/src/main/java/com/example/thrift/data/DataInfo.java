/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.example.thrift.data;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-24")
public class DataInfo implements org.apache.thrift.TBase<DataInfo, DataInfo._Fields>, java.io.Serializable, Cloneable, Comparable<DataInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DataInfo");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField IDENTIFY_FIELD_DESC = new org.apache.thrift.protocol.TField("identify", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField DATETIME_FIELD_DESC = new org.apache.thrift.protocol.TField("datetime", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField COMMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("comment", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DataInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DataInfoTupleSchemeFactory();

  public java.lang.String id; // required
  public java.lang.String identify; // required
  public java.lang.String datetime; // required
  public java.lang.String value; // required
  public java.lang.String comment; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    IDENTIFY((short)2, "identify"),
    DATETIME((short)3, "datetime"),
    VALUE((short)4, "value"),
    COMMENT((short)5, "comment");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // IDENTIFY
          return IDENTIFY;
        case 3: // DATETIME
          return DATETIME;
        case 4: // VALUE
          return VALUE;
        case 5: // COMMENT
          return COMMENT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IDENTIFY, new org.apache.thrift.meta_data.FieldMetaData("identify", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATETIME, new org.apache.thrift.meta_data.FieldMetaData("datetime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMMENT, new org.apache.thrift.meta_data.FieldMetaData("comment", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DataInfo.class, metaDataMap);
  }

  public DataInfo() {
  }

  public DataInfo(
    java.lang.String id,
    java.lang.String identify,
    java.lang.String datetime,
    java.lang.String value,
    java.lang.String comment)
  {
    this();
    this.id = id;
    this.identify = identify;
    this.datetime = datetime;
    this.value = value;
    this.comment = comment;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DataInfo(DataInfo other) {
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetIdentify()) {
      this.identify = other.identify;
    }
    if (other.isSetDatetime()) {
      this.datetime = other.datetime;
    }
    if (other.isSetValue()) {
      this.value = other.value;
    }
    if (other.isSetComment()) {
      this.comment = other.comment;
    }
  }

  public DataInfo deepCopy() {
    return new DataInfo(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.identify = null;
    this.datetime = null;
    this.value = null;
    this.comment = null;
  }

  public java.lang.String getId() {
    return this.id;
  }

  public DataInfo setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public java.lang.String getIdentify() {
    return this.identify;
  }

  public DataInfo setIdentify(java.lang.String identify) {
    this.identify = identify;
    return this;
  }

  public void unsetIdentify() {
    this.identify = null;
  }

  /** Returns true if field identify is set (has been assigned a value) and false otherwise */
  public boolean isSetIdentify() {
    return this.identify != null;
  }

  public void setIdentifyIsSet(boolean value) {
    if (!value) {
      this.identify = null;
    }
  }

  public java.lang.String getDatetime() {
    return this.datetime;
  }

  public DataInfo setDatetime(java.lang.String datetime) {
    this.datetime = datetime;
    return this;
  }

  public void unsetDatetime() {
    this.datetime = null;
  }

  /** Returns true if field datetime is set (has been assigned a value) and false otherwise */
  public boolean isSetDatetime() {
    return this.datetime != null;
  }

  public void setDatetimeIsSet(boolean value) {
    if (!value) {
      this.datetime = null;
    }
  }

  public java.lang.String getValue() {
    return this.value;
  }

  public DataInfo setValue(java.lang.String value) {
    this.value = value;
    return this;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  public java.lang.String getComment() {
    return this.comment;
  }

  public DataInfo setComment(java.lang.String comment) {
    this.comment = comment;
    return this;
  }

  public void unsetComment() {
    this.comment = null;
  }

  /** Returns true if field comment is set (has been assigned a value) and false otherwise */
  public boolean isSetComment() {
    return this.comment != null;
  }

  public void setCommentIsSet(boolean value) {
    if (!value) {
      this.comment = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.String)value);
      }
      break;

    case IDENTIFY:
      if (value == null) {
        unsetIdentify();
      } else {
        setIdentify((java.lang.String)value);
      }
      break;

    case DATETIME:
      if (value == null) {
        unsetDatetime();
      } else {
        setDatetime((java.lang.String)value);
      }
      break;

    case VALUE:
      if (value == null) {
        unsetValue();
      } else {
        setValue((java.lang.String)value);
      }
      break;

    case COMMENT:
      if (value == null) {
        unsetComment();
      } else {
        setComment((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case IDENTIFY:
      return getIdentify();

    case DATETIME:
      return getDatetime();

    case VALUE:
      return getValue();

    case COMMENT:
      return getComment();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case IDENTIFY:
      return isSetIdentify();
    case DATETIME:
      return isSetDatetime();
    case VALUE:
      return isSetValue();
    case COMMENT:
      return isSetComment();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof DataInfo)
      return this.equals((DataInfo)that);
    return false;
  }

  public boolean equals(DataInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_identify = true && this.isSetIdentify();
    boolean that_present_identify = true && that.isSetIdentify();
    if (this_present_identify || that_present_identify) {
      if (!(this_present_identify && that_present_identify))
        return false;
      if (!this.identify.equals(that.identify))
        return false;
    }

    boolean this_present_datetime = true && this.isSetDatetime();
    boolean that_present_datetime = true && that.isSetDatetime();
    if (this_present_datetime || that_present_datetime) {
      if (!(this_present_datetime && that_present_datetime))
        return false;
      if (!this.datetime.equals(that.datetime))
        return false;
    }

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
        return false;
    }

    boolean this_present_comment = true && this.isSetComment();
    boolean that_present_comment = true && that.isSetComment();
    if (this_present_comment || that_present_comment) {
      if (!(this_present_comment && that_present_comment))
        return false;
      if (!this.comment.equals(that.comment))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetId()) ? 131071 : 524287);
    if (isSetId())
      hashCode = hashCode * 8191 + id.hashCode();

    hashCode = hashCode * 8191 + ((isSetIdentify()) ? 131071 : 524287);
    if (isSetIdentify())
      hashCode = hashCode * 8191 + identify.hashCode();

    hashCode = hashCode * 8191 + ((isSetDatetime()) ? 131071 : 524287);
    if (isSetDatetime())
      hashCode = hashCode * 8191 + datetime.hashCode();

    hashCode = hashCode * 8191 + ((isSetValue()) ? 131071 : 524287);
    if (isSetValue())
      hashCode = hashCode * 8191 + value.hashCode();

    hashCode = hashCode * 8191 + ((isSetComment()) ? 131071 : 524287);
    if (isSetComment())
      hashCode = hashCode * 8191 + comment.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(DataInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIdentify()).compareTo(other.isSetIdentify());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIdentify()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.identify, other.identify);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDatetime()).compareTo(other.isSetDatetime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDatetime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.datetime, other.datetime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetValue()).compareTo(other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value, other.value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetComment()).compareTo(other.isSetComment());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetComment()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.comment, other.comment);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("DataInfo(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("identify:");
    if (this.identify == null) {
      sb.append("null");
    } else {
      sb.append(this.identify);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("datetime:");
    if (this.datetime == null) {
      sb.append("null");
    } else {
      sb.append(this.datetime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("value:");
    if (this.value == null) {
      sb.append("null");
    } else {
      sb.append(this.value);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("comment:");
    if (this.comment == null) {
      sb.append("null");
    } else {
      sb.append(this.comment);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DataInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DataInfoStandardScheme getScheme() {
      return new DataInfoStandardScheme();
    }
  }

  private static class DataInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<DataInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DataInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IDENTIFY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.identify = iprot.readString();
              struct.setIdentifyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATETIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.datetime = iprot.readString();
              struct.setDatetimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.value = iprot.readString();
              struct.setValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COMMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.comment = iprot.readString();
              struct.setCommentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DataInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.identify != null) {
        oprot.writeFieldBegin(IDENTIFY_FIELD_DESC);
        oprot.writeString(struct.identify);
        oprot.writeFieldEnd();
      }
      if (struct.datetime != null) {
        oprot.writeFieldBegin(DATETIME_FIELD_DESC);
        oprot.writeString(struct.datetime);
        oprot.writeFieldEnd();
      }
      if (struct.value != null) {
        oprot.writeFieldBegin(VALUE_FIELD_DESC);
        oprot.writeString(struct.value);
        oprot.writeFieldEnd();
      }
      if (struct.comment != null) {
        oprot.writeFieldBegin(COMMENT_FIELD_DESC);
        oprot.writeString(struct.comment);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DataInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DataInfoTupleScheme getScheme() {
      return new DataInfoTupleScheme();
    }
  }

  private static class DataInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<DataInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DataInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetIdentify()) {
        optionals.set(1);
      }
      if (struct.isSetDatetime()) {
        optionals.set(2);
      }
      if (struct.isSetValue()) {
        optionals.set(3);
      }
      if (struct.isSetComment()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetIdentify()) {
        oprot.writeString(struct.identify);
      }
      if (struct.isSetDatetime()) {
        oprot.writeString(struct.datetime);
      }
      if (struct.isSetValue()) {
        oprot.writeString(struct.value);
      }
      if (struct.isSetComment()) {
        oprot.writeString(struct.comment);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DataInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.identify = iprot.readString();
        struct.setIdentifyIsSet(true);
      }
      if (incoming.get(2)) {
        struct.datetime = iprot.readString();
        struct.setDatetimeIsSet(true);
      }
      if (incoming.get(3)) {
        struct.value = iprot.readString();
        struct.setValueIsSet(true);
      }
      if (incoming.get(4)) {
        struct.comment = iprot.readString();
        struct.setCommentIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

