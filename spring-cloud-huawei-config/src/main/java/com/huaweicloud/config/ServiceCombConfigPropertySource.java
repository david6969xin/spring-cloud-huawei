/*

  * Copyright (C) 2020-2022 Huawei Technologies Co., Ltd. All rights reserved.

  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

package com.huaweicloud.config;

import java.util.Set;

import org.apache.servicecomb.config.common.ConfigConverter;
import org.springframework.core.env.EnumerablePropertySource;

public class ServiceCombConfigPropertySource extends EnumerablePropertySource<ConfigConverter> {
  public static final String NAME = "servicecomb";

  private final ConfigConverter configConverter;

  public ServiceCombConfigPropertySource(ConfigConverter configConverter) {
    super(NAME, configConverter);
    this.configConverter = configConverter;
  }

  @Override
  public String[] getPropertyNames() {
    Set<String> strings = this.configConverter.getCurrentData().keySet();
    return strings.toArray(new String[strings.size()]);
  }

  @Override
  public Object getProperty(String name) {
    return this.configConverter.getCurrentData().get(name);
  }
}
