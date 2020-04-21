// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: datahem/options/options.proto

package org.datahem.protobuf.options;

/*-
 * ========================LICENSE_START=================================
 * DataHem
 * %%
 * Copyright (C) 2018 - 2019 MatHem Sverige AB
 * %%
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.
 * =========================LICENSE_END==================================
 */

public final class Options {
  private Options() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(org.datahem.protobuf.options.Options.bigQueryTableReference);
    registry.add(org.datahem.protobuf.options.Options.bigQueryTableDescription);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldDescription);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldCategories);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldType);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldRename);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldAppend);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldRegexExtract);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldRegexReplace);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldLocalToUtc);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldHidden);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldUseDefaultValue);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldCoalesce);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldDivide);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldFilter);
    registry.add(org.datahem.protobuf.options.Options.bigQueryFieldPolicyTags);
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public static final int BIGQUERYTABLEREFERENCE_FIELD_NUMBER = 66666667;
  /**
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> bigQueryTableReference = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYTABLEDESCRIPTION_FIELD_NUMBER = 66666668;
  /**
   * <code>extend .google.protobuf.MessageOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.MessageOptions,
      java.lang.String> bigQueryTableDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDDESCRIPTION_FIELD_NUMBER = 66666667;
  /**
   * <pre>
   * Sets a description for the field in BigQuery
   * [DescriptionString] Example: "A timestamp."
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldDescription = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDCATEGORIES_FIELD_NUMBER = 66666668;
  /**
   * <pre>
   * Deprecated. Sets a category on the field in BigQuery
   * [Category1, Category2,...] Example:
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldCategories = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDTYPE_FIELD_NUMBER = 66666669;
  /**
   * <pre>
   * Sets a specified data type on the field in bigquery, if not set the corresponding protobuf data type is used for mapping
   *String [BigQueryDataType] Example: "TIMESTAMP"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldType = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDRENAME_FIELD_NUMBER = 66666670;
  /**
   * <pre>
   * Rename a field
   *String [NewFieldName] Example: "LocalDateTime"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldRename = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDAPPEND_FIELD_NUMBER = 66666671;
  /**
   * <pre>
   * Append string to value
   *String [AppendString] Example: "Europe/Stockholm"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldAppend = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDREGEXEXTRACT_FIELD_NUMBER = 66666672;
  /**
   * <pre>
   * Extract part of value (string)
   *String [RegexPattern] Example "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])(T| )(2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldRegexExtract = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDREGEXREPLACE_FIELD_NUMBER = 66666673;
  /**
   * <pre>
   * Replace part of value (string)
   *String [RegexPattern, ReplacementString] Example: "(&#92;&#92;+(2[0-3]|[01][0-9]):[0-5][0-9]),Europe/Stockholm"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldRegexReplace = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDLOCALTOUTC_FIELD_NUMBER = 66666674;
  /**
   * <pre>
   * Convert timestamp from local zone to UTC
   *String [LocalTimezone, LocalPattern, UtcPattern ] Example: "Europe/Stockholm, yyyy-MM-dd'T'HH:mm:ss, yyyy-MM-dd'T'HH:mm:ssXXX"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldLocalToUtc = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDHIDDEN_FIELD_NUMBER = 66666675;
  /**
   * <pre>
   *Hide field from BigQuery table
   *boolean [Hidden] Example: "true"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldHidden = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDUSEDEFAULTVALUE_FIELD_NUMBER = 66666676;
  /**
   * <pre>
   *Use default protobuf value or not if field is null, default is false
   *boolean [UseDefault] Example: "false"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldUseDefaultValue = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDCOALESCE_FIELD_NUMBER = 66666677;
  /**
   * <pre>
   *replace value with first non-null value
   *Object [field1, field2, ...] Example: "removedDate, lastModifiedDate, creationDate"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldCoalesce = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDDIVIDE_FIELD_NUMBER = 66666678;
  /**
   * <pre>
   *Divide field value with divisor
   *double [divisor] Example: "100"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldDivide = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDFILTER_FIELD_NUMBER = 66666679;
  /**
   * <pre>
   *Filter string with regex pattern
   *String [pattern] Example: "^((?!0001-01-01.00:00:00).)*$"
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldFilter = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);
  public static final int BIGQUERYFIELDPOLICYTAGS_FIELD_NUMBER = 66666680;
  /**
   * <pre>
   * Sets a policy tag on the field in BigQuery
   * [PolicyTag1, PolicyTag2,...] At most one policytag can be used per field
   * </pre>
   *
   * <code>extend .google.protobuf.FieldOptions { ... }</code>
   */
  public static final
    com.google.protobuf.GeneratedMessage.GeneratedExtension<
      com.google.protobuf.DescriptorProtos.FieldOptions,
      java.lang.String> bigQueryFieldPolicyTags = com.google.protobuf.GeneratedMessage
          .newFileScopedGeneratedExtension(
        java.lang.String.class,
        null);

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035datahem/options/options.proto\022\017datahem" +
      ".options\032 google/protobuf/descriptor.pro" +
      "to:B\n\026BigQueryTableReference\022\037.google.pr" +
      "otobuf.MessageOptions\030\253\201\345\037 \001(\t:D\n\030BigQue" +
      "ryTableDescription\022\037.google.protobuf.Mes" +
      "sageOptions\030\254\201\345\037 \001(\t:B\n\030BigQueryFieldDes" +
      "cription\022\035.google.protobuf.FieldOptions\030" +
      "\253\201\345\037 \001(\t:A\n\027BigQueryFieldCategories\022\035.go" +
      "ogle.protobuf.FieldOptions\030\254\201\345\037 \001(\t:;\n\021B" +
      "igQueryFieldType\022\035.google.protobuf.Field" +
      "Options\030\255\201\345\037 \001(\t:=\n\023BigQueryFieldRename\022" +
      "\035.google.protobuf.FieldOptions\030\256\201\345\037 \001(\t:" +
      "=\n\023BigQueryFieldAppend\022\035.google.protobuf" +
      ".FieldOptions\030\257\201\345\037 \001(\t:C\n\031BigQueryFieldR" +
      "egexExtract\022\035.google.protobuf.FieldOptio" +
      "ns\030\260\201\345\037 \001(\t:C\n\031BigQueryFieldRegexReplace" +
      "\022\035.google.protobuf.FieldOptions\030\261\201\345\037 \001(\t" +
      ":A\n\027BigQueryFieldLocalToUtc\022\035.google.pro" +
      "tobuf.FieldOptions\030\262\201\345\037 \001(\t:=\n\023BigQueryF" +
      "ieldHidden\022\035.google.protobuf.FieldOption" +
      "s\030\263\201\345\037 \001(\t:F\n\034BigQueryFieldUseDefaultVal" +
      "ue\022\035.google.protobuf.FieldOptions\030\264\201\345\037 \001" +
      "(\t:?\n\025BigQueryFieldCoalesce\022\035.google.pro" +
      "tobuf.FieldOptions\030\265\201\345\037 \001(\t:=\n\023BigQueryF" +
      "ieldDivide\022\035.google.protobuf.FieldOption" +
      "s\030\266\201\345\037 \001(\t:=\n\023BigQueryFieldFilter\022\035.goog" +
      "le.protobuf.FieldOptions\030\267\201\345\037 \001(\t:A\n\027Big" +
      "QueryFieldPolicyTags\022\035.google.protobuf.F" +
      "ieldOptions\030\270\201\345\037 \001(\tB\036\n\034org.datahem.prot" +
      "obuf.optionsb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.DescriptorProtos.getDescriptor(),
        }, assigner);
    bigQueryTableReference.internalInit(descriptor.getExtensions().get(0));
    bigQueryTableDescription.internalInit(descriptor.getExtensions().get(1));
    bigQueryFieldDescription.internalInit(descriptor.getExtensions().get(2));
    bigQueryFieldCategories.internalInit(descriptor.getExtensions().get(3));
    bigQueryFieldType.internalInit(descriptor.getExtensions().get(4));
    bigQueryFieldRename.internalInit(descriptor.getExtensions().get(5));
    bigQueryFieldAppend.internalInit(descriptor.getExtensions().get(6));
    bigQueryFieldRegexExtract.internalInit(descriptor.getExtensions().get(7));
    bigQueryFieldRegexReplace.internalInit(descriptor.getExtensions().get(8));
    bigQueryFieldLocalToUtc.internalInit(descriptor.getExtensions().get(9));
    bigQueryFieldHidden.internalInit(descriptor.getExtensions().get(10));
    bigQueryFieldUseDefaultValue.internalInit(descriptor.getExtensions().get(11));
    bigQueryFieldCoalesce.internalInit(descriptor.getExtensions().get(12));
    bigQueryFieldDivide.internalInit(descriptor.getExtensions().get(13));
    bigQueryFieldFilter.internalInit(descriptor.getExtensions().get(14));
    bigQueryFieldPolicyTags.internalInit(descriptor.getExtensions().get(15));
    com.google.protobuf.DescriptorProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}