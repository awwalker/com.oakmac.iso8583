(ns com.oakmac.iso8583.format-iso8583
  (:require
    [com.oakmac.iso8583.binary :refer [bytes-to-hex]]
    [com.oakmac.iso8583.format :refer [fixed-length-field make-field-definitions variable-length-field]]))

(defn field-definitions []
  (make-field-definitions
    [[2 :pan (variable-length-field 2)]
     [3 :processing-code (fixed-length-field 6)]
     [4 :transaction-amount (fixed-length-field 12)]
     [7 :transmission-date-time (fixed-length-field 10)]
     [11 :stan (fixed-length-field 6)]
     [12 :local-transaction-time (fixed-length-field 6)]
     [13 :local-transaction-date (fixed-length-field 4)]
     [14 :card-expiry-date (fixed-length-field 4)]
     [15 :transaction-settlement-date (fixed-length-field 4)]
     [18 :merchant-type (fixed-length-field 4)]
     [22 :pos-entry-mode (fixed-length-field 3)]
     [23 :card-sequence-number (fixed-length-field 3)]
     [25 :pos-condition-code (fixed-length-field 2)]
     [26 :pos-capture-code (fixed-length-field 2)]
     [28 :transaction-fee-amount (fixed-length-field 9)]
     [30 :transaction-processing-fee (fixed-length-field 9)]
     [32 :acquiring-institution-id-code (variable-length-field 2)]
     [35 :track-2 (variable-length-field 2)]
     [37 :retrieval-reference-number (fixed-length-field 12)]
     [40 :service-restriction-code (fixed-length-field 3)]
     [41 :terminal-id (fixed-length-field 8)]
     [42 :card-acceptor-id (fixed-length-field 15)]
     [43 :card-acceptor-name-location (fixed-length-field 40)]
     [49 :transaction-currency (fixed-length-field 3)]
     [52 :pin-data (fixed-length-field 8) :codec {:decoder bytes-to-hex}]
     [56 :message-reason-code (variable-length-field 3)]
     [100 :receiving-institution-id-code (variable-length-field 2)]
     [123 :pos-data-code (variable-length-field 3)]
     [127 :postilion-private-data (variable-length-field 6)]]))

