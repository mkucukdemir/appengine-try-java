/*
 * Copyright 2017 mkucukdemir.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smallfe.clerk.model;

import com.smallfe.clerk.UIMessageStatus;

/**
 * Messages for remote calls.
 * @author mkucukdemir
 */
public class UIMessage {
  
  private UIMessageStatus uiMessageStatus;
  private String uiMessage;

  public UIMessage() {
  }

  public UIMessage(UIMessageStatus uiMessageStatus, String uiMessage) {
    this.uiMessageStatus = uiMessageStatus;
    this.uiMessage = uiMessage;
  }

  /**
   * @return the uiMessageStatus
   */
  public UIMessageStatus getUiMessageStatus() {
    return uiMessageStatus;
  }

  /**
   * @param uiMessageStatus the uiMessageStatus to set
   */
  public void setUiMessageStatus(UIMessageStatus uiMessageStatus) {
    this.uiMessageStatus = uiMessageStatus;
  }

  /**
   * @return the uiMessage
   */
  public String getUiMessage() {
    return uiMessage;
  }

  /**
   * @param uiMessage the uiMessage to set
   */
  public void setUiMessage(String uiMessage) {
    this.uiMessage = uiMessage;
  }
          
}
