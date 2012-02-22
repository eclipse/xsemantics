package it.xsemantics.example.expressions.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import it.xsemantics.example.expressions.services.ExpressionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'+'", "'-'", "'*'", "'/'", "'<'", "'=='", "'||'", "'&&'", "'('", "')'", "'!'", "'true'", "'false'"
    };
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g"; }



     	private ExpressionsGrammarAccess grammarAccess;
     	
        public InternalExpressionsParser(TokenStream input, ExpressionsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ExpressionsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:69:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:76:1: ruleModel returns [EObject current=null] : ( (lv_variables_0_0= ruleVariable ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_variables_0_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:79:28: ( ( (lv_variables_0_0= ruleVariable ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:80:1: ( (lv_variables_0_0= ruleVariable ) )*
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:80:1: ( (lv_variables_0_0= ruleVariable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:81:1: (lv_variables_0_0= ruleVariable )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:81:1: (lv_variables_0_0= ruleVariable )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:82:3: lv_variables_0_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getVariablesVariableParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleVariable_in_ruleModel130);
            	    lv_variables_0_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"variables",
            	              		lv_variables_0_0, 
            	              		"Variable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleVariable"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:106:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:107:2: (iv_ruleVariable= ruleVariable EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:108:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable166);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable176); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:115:1: ruleVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:118:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:119:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:119:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:119:2: ( (lv_name_0_0= RULE_ID ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:120:1: (lv_name_0_0= RULE_ID )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:120:1: (lv_name_0_0= RULE_ID )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:121:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariable218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleVariable235); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getEqualsSignKeyword_1());
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:141:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:142:1: (lv_expression_2_0= ruleExpression )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:142:1: (lv_expression_2_0= ruleExpression )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:143:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleVariable256);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleExpression"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:167:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:168:2: (iv_ruleExpression= ruleExpression EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:169:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression292);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression302); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:176:1: ruleExpression returns [EObject current=null] : this_Addition_0= ruleAddition ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:179:28: (this_Addition_0= ruleAddition )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:181:5: this_Addition_0= ruleAddition
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getAdditionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleExpression348);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:197:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:198:2: (iv_ruleAddition= ruleAddition EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:199:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition382);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition392); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:206:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:209:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:210:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:210:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:211:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition439);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=12 && LA3_0<=13)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==12) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==13) ) {
            	        alt2=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:3: ( () otherlv_2= '+' )
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:3: ( () otherlv_2= '+' )
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:4: () otherlv_2= '+'
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:4: ()
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:220:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleAddition462); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:230:6: ( () otherlv_4= '-' )
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:230:6: ( () otherlv_4= '-' )
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:230:7: () otherlv_4= '-'
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:230:7: ()
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:231:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleAddition491); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:240:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:241:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:241:1: (lv_right_5_0= ruleMultiplication )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:242:3: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition514);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"Multiplication");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:266:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:267:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:268:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication552);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication562); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:275:1: ruleMultiplication returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:278:28: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:279:1: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:279:1: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:280:5: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getComparisonParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleComparison_in_ruleMultiplication609);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Comparison_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:288:1: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=14 && LA5_0<=15)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:288:2: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:288:2: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:288:3: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:288:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:289:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:294:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:295:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:295:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:296:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:296:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==14) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==15) ) {
            	        alt4=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:297:3: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,14,FOLLOW_14_in_ruleMultiplication639); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getMultiplicationAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicationRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:309:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,15,FOLLOW_15_in_ruleMultiplication668); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getMultiplicationAccess().getOpSolidusKeyword_1_0_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getMultiplicationRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:324:3: ( (lv_right_3_0= ruleComparison ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:325:1: (lv_right_3_0= ruleComparison )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:325:1: (lv_right_3_0= ruleComparison )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:326:3: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleComparison_in_ruleMultiplication706);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Comparison");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleComparison"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:350:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:351:2: (iv_ruleComparison= ruleComparison EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:352:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison744);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison754); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:359:1: ruleComparison returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_BooleanExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:362:28: ( (this_BooleanExpression_0= ruleBooleanExpression ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:363:1: (this_BooleanExpression_0= ruleBooleanExpression ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:363:1: (this_BooleanExpression_0= ruleBooleanExpression ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:364:5: this_BooleanExpression_0= ruleBooleanExpression ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getComparisonAccess().getBooleanExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_ruleComparison801);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BooleanExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:372:1: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=16 && LA7_0<=17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:372:2: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleBooleanExpression ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:372:2: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:372:3: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:372:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:373:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:378:2: ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:379:1: ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:379:1: ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:380:1: (lv_op_2_1= '<' | lv_op_2_2= '==' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:380:1: (lv_op_2_1= '<' | lv_op_2_2= '==' )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==16) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==17) ) {
            	        alt6=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:381:3: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,16,FOLLOW_16_in_ruleComparison831); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getComparisonRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:393:8: lv_op_2_2= '=='
            	            {
            	            lv_op_2_2=(Token)match(input,17,FOLLOW_17_in_ruleComparison860); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpEqualsSignEqualsSignKeyword_1_0_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getComparisonRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:408:3: ( (lv_right_3_0= ruleBooleanExpression ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:409:1: (lv_right_3_0= ruleBooleanExpression )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:409:1: (lv_right_3_0= ruleBooleanExpression )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:410:3: lv_right_3_0= ruleBooleanExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComparisonAccess().getRightBooleanExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBooleanExpression_in_ruleComparison898);
            	    lv_right_3_0=ruleBooleanExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"BooleanExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleBooleanExpression"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:434:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:435:2: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:436:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression936);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression946); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:443:1: ruleBooleanExpression returns [EObject current=null] : (this_Atomic_0= ruleAtomic ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Atomic_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:446:28: ( (this_Atomic_0= ruleAtomic ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:447:1: (this_Atomic_0= ruleAtomic ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:447:1: (this_Atomic_0= ruleAtomic ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:448:5: this_Atomic_0= ruleAtomic ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBooleanExpressionAccess().getAtomicParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAtomic_in_ruleBooleanExpression993);
            this_Atomic_0=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Atomic_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:1: ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=18 && LA9_0<=19)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:2: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleAtomic ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:2: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:3: () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:457:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:462:2: ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:463:1: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:463:1: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:464:1: (lv_op_2_1= '||' | lv_op_2_2= '&&' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:464:1: (lv_op_2_1= '||' | lv_op_2_2= '&&' )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==18) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==19) ) {
            	        alt8=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:465:3: lv_op_2_1= '||'
            	            {
            	            lv_op_2_1=(Token)match(input,18,FOLLOW_18_in_ruleBooleanExpression1023); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_1, grammarAccess.getBooleanExpressionAccess().getOpVerticalLineVerticalLineKeyword_1_0_1_0_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              	    
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:477:8: lv_op_2_2= '&&'
            	            {
            	            lv_op_2_2=(Token)match(input,19,FOLLOW_19_in_ruleBooleanExpression1052); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_op_2_2, grammarAccess.getBooleanExpressionAccess().getOpAmpersandAmpersandKeyword_1_0_1_0_1());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getBooleanExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              	    
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:492:3: ( (lv_right_3_0= ruleAtomic ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:493:1: (lv_right_3_0= ruleAtomic )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:493:1: (lv_right_3_0= ruleAtomic )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:494:3: lv_right_3_0= ruleAtomic
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBooleanExpressionAccess().getRightAtomicParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAtomic_in_ruleBooleanExpression1090);
            	    lv_right_3_0=ruleAtomic();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_3_0, 
            	              		"Atomic");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleAtomic"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:518:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:519:2: (iv_ruleAtomic= ruleAtomic EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:520:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic1128);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic1138); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:527:1: ruleAtomic returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) ) | ( () ( (lv_value_10_0= RULE_INT ) ) ) | ( () ( (lv_value_12_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) ) | ( () ( (otherlv_16= RULE_ID ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_value_10_0=null;
        Token lv_value_12_0=null;
        Token lv_value_14_1=null;
        Token lv_value_14_2=null;
        Token otherlv_16=null;
        EObject this_Expression_1 = null;

        EObject lv_expression_5_0 = null;

        EObject lv_expression_8_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:530:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) ) | ( () ( (lv_value_10_0= RULE_INT ) ) ) | ( () ( (lv_value_12_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) ) | ( () ( (otherlv_16= RULE_ID ) ) ) ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) ) | ( () ( (lv_value_10_0= RULE_INT ) ) ) | ( () ( (lv_value_12_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) ) | ( () ( (otherlv_16= RULE_ID ) ) ) )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) ) | ( () ( (lv_value_10_0= RULE_INT ) ) ) | ( () ( (lv_value_12_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) ) | ( () ( (otherlv_16= RULE_ID ) ) ) )
            int alt11=7;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt11=1;
                }
                break;
            case 22:
                {
                alt11=2;
                }
                break;
            case 13:
                {
                alt11=3;
                }
                break;
            case RULE_INT:
                {
                alt11=4;
                }
                break;
            case RULE_STRING:
                {
                alt11=5;
                }
                break;
            case 23:
            case 24:
                {
                alt11=6;
                }
                break;
            case RULE_ID:
                {
                alt11=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleAtomic1176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleAtomic1198);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleAtomic1209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:549:6: ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:549:6: ( () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:549:7: () ( ( '!' )=>otherlv_4= '!' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:549:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:550:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getBooleanNegationAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:555:2: ( ( '!' )=>otherlv_4= '!' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:555:3: ( '!' )=>otherlv_4= '!'
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleAtomic1246); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAtomicAccess().getExclamationMarkKeyword_1_1());
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:560:2: ( (lv_expression_5_0= ruleAtomic ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:1: (lv_expression_5_0= ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:1: (lv_expression_5_0= ruleAtomic )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:562:3: lv_expression_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_ruleAtomic1268);
                    lv_expression_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_5_0, 
                              		"Atomic");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:579:6: ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:579:6: ( () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:579:7: () ( ( '-' )=>otherlv_7= '-' ) ( (lv_expression_8_0= ruleAtomic ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:579:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:580:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getArithmeticSignedAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:585:2: ( ( '-' )=>otherlv_7= '-' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:585:3: ( '-' )=>otherlv_7= '-'
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_13_in_ruleAtomic1305); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getAtomicAccess().getHyphenMinusKeyword_2_1());
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:590:2: ( (lv_expression_8_0= ruleAtomic ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:591:1: (lv_expression_8_0= ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:591:1: (lv_expression_8_0= ruleAtomic )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:592:3: lv_expression_8_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAtomicAccess().getExpressionAtomicParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_ruleAtomic1327);
                    lv_expression_8_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAtomicRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_8_0, 
                              		"Atomic");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:609:6: ( () ( (lv_value_10_0= RULE_INT ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:609:6: ( () ( (lv_value_10_0= RULE_INT ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:609:7: () ( (lv_value_10_0= RULE_INT ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:609:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:610:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getNumberLiteralAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:615:2: ( (lv_value_10_0= RULE_INT ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:616:1: (lv_value_10_0= RULE_INT )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:616:1: (lv_value_10_0= RULE_INT )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:617:3: lv_value_10_0= RULE_INT
                    {
                    lv_value_10_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAtomic1361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_10_0, grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_10_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:634:6: ( () ( (lv_value_12_0= RULE_STRING ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:634:6: ( () ( (lv_value_12_0= RULE_STRING ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:634:7: () ( (lv_value_12_0= RULE_STRING ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:634:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:635:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getStringLiteralAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:640:2: ( (lv_value_12_0= RULE_STRING ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:641:1: (lv_value_12_0= RULE_STRING )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:641:1: (lv_value_12_0= RULE_STRING )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:642:3: lv_value_12_0= RULE_STRING
                    {
                    lv_value_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomic1400); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_12_0, grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:659:6: ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:659:6: ( () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:659:7: () ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:659:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:660:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getBooleanLiteralAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:665:2: ( ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:666:1: ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:666:1: ( (lv_value_14_1= 'true' | lv_value_14_2= 'false' ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:667:1: (lv_value_14_1= 'true' | lv_value_14_2= 'false' )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:667:1: (lv_value_14_1= 'true' | lv_value_14_2= 'false' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==23) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==24) ) {
                        alt10=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:668:3: lv_value_14_1= 'true'
                            {
                            lv_value_14_1=(Token)match(input,23,FOLLOW_23_in_ruleAtomic1442); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_value_14_1, grammarAccess.getAtomicAccess().getValueTrueKeyword_5_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicRule());
                              	        }
                                     		setWithLastConsumed(current, "value", lv_value_14_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:680:8: lv_value_14_2= 'false'
                            {
                            lv_value_14_2=(Token)match(input,24,FOLLOW_24_in_ruleAtomic1471); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_value_14_2, grammarAccess.getAtomicAccess().getValueFalseKeyword_5_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicRule());
                              	        }
                                     		setWithLastConsumed(current, "value", lv_value_14_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:6: ( () ( (otherlv_16= RULE_ID ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:6: ( () ( (otherlv_16= RULE_ID ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:7: () ( (otherlv_16= RULE_ID ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:697:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getVariableReferenceAction_6_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:702:2: ( (otherlv_16= RULE_ID ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:703:1: (otherlv_16= RULE_ID )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:703:1: (otherlv_16= RULE_ID )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:704:3: otherlv_16= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                              
                    }
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomic1524); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_16, grammarAccess.getAtomicAccess().getRefVariableCrossReference_6_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleModel130 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariable218 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleVariable235 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariable256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleExpression348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition439 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleAddition462 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_13_in_ruleAddition491 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition514 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleMultiplication609 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_ruleMultiplication639 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_15_in_ruleMultiplication668 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleMultiplication706 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleComparison801 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_16_in_ruleComparison831 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_17_in_ruleComparison860 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleComparison898 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_ruleBooleanExpression993 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleBooleanExpression1023 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_19_in_ruleBooleanExpression1052 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleAtomic_in_ruleBooleanExpression1090 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic1128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleAtomic1176 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAtomic1198 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAtomic1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleAtomic1246 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleAtomic_in_ruleAtomic1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleAtomic1305 = new BitSet(new long[]{0x0000000001D02070L});
    public static final BitSet FOLLOW_ruleAtomic_in_ruleAtomic1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAtomic1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomic1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAtomic1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAtomic1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomic1524 = new BitSet(new long[]{0x0000000000000002L});

}