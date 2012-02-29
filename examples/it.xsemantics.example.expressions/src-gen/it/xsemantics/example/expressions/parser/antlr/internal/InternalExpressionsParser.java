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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'||'", "'&&'", "'<'", "'=='", "'+'", "'-'", "'*'", "'/'", "'!'", "'('", "')'", "'true'", "'false'"
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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:176:1: ruleExpression returns [EObject current=null] : this_BooleanExpression_0= ruleBooleanExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanExpression_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:179:28: (this_BooleanExpression_0= ruleBooleanExpression )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:181:5: this_BooleanExpression_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getBooleanExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_ruleExpression348);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BooleanExpression_0; 
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


    // $ANTLR start "entryRuleBooleanExpression"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:197:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:198:2: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:199:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression382);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression392); if (state.failed) return current;

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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:206:1: ruleBooleanExpression returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:209:28: ( (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:210:1: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:210:1: (this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:211:5: this_Comparison_0= ruleComparison ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBooleanExpressionAccess().getComparisonParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleComparison_in_ruleBooleanExpression439);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Comparison_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:1: ( ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=12 && LA3_0<=13)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:2: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:2: ( () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:3: () ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:219:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:220:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getBooleanExpressionAccess().getAndOrExpressionLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:225:2: ( ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:226:1: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:226:1: ( (lv_op_2_1= '||' | lv_op_2_2= '&&' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:227:1: (lv_op_2_1= '||' | lv_op_2_2= '&&' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:227:1: (lv_op_2_1= '||' | lv_op_2_2= '&&' )
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:228:3: lv_op_2_1= '||'
            	            {
            	            lv_op_2_1=(Token)match(input,12,FOLLOW_12_in_ruleBooleanExpression469); if (state.failed) return current;
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:240:8: lv_op_2_2= '&&'
            	            {
            	            lv_op_2_2=(Token)match(input,13,FOLLOW_13_in_ruleBooleanExpression498); if (state.failed) return current;
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

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:255:3: ( (lv_right_3_0= ruleComparison ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:256:1: (lv_right_3_0= ruleComparison )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:256:1: (lv_right_3_0= ruleComparison )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:257:3: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBooleanExpressionAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleComparison_in_ruleBooleanExpression536);
            	    lv_right_3_0=ruleComparison();

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
            	              		"Comparison");
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
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleComparison"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:281:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:282:2: (iv_ruleComparison= ruleComparison EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:283:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison574);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison584); if (state.failed) return current;

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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:290:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Addition_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:293:28: ( (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:294:1: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:294:1: (this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:295:5: this_Addition_0= ruleAddition ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison631);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:303:1: ( ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=14 && LA5_0<=15)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:303:2: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) ) ( (lv_right_3_0= ruleAddition ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:303:2: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:303:3: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:303:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:304:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:309:2: ( ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:310:1: ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:310:1: ( (lv_op_2_1= '<' | lv_op_2_2= '==' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:311:1: (lv_op_2_1= '<' | lv_op_2_2= '==' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:311:1: (lv_op_2_1= '<' | lv_op_2_2= '==' )
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:312:3: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,14,FOLLOW_14_in_ruleComparison661); if (state.failed) return current;
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:324:8: lv_op_2_2= '=='
            	            {
            	            lv_op_2_2=(Token)match(input,15,FOLLOW_15_in_ruleComparison690); if (state.failed) return current;
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

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:339:3: ( (lv_right_3_0= ruleAddition ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:340:1: (lv_right_3_0= ruleAddition )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:340:1: (lv_right_3_0= ruleAddition )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:341:3: lv_right_3_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison728);
            	    lv_right_3_0=ruleAddition();

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
            	              		"Addition");
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:365:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:366:2: (iv_ruleAddition= ruleAddition EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:367:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition766);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition776); if (state.failed) return current;

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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:374:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:377:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:378:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:378:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:379:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition823);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=16 && LA7_0<=17)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:3: ( () otherlv_2= '+' )
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:3: ( () otherlv_2= '+' )
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:4: () otherlv_2= '+'
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:387:4: ()
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:388:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleAddition846); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:398:6: ( () otherlv_4= '-' )
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:398:6: ( () otherlv_4= '-' )
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:398:7: () otherlv_4= '-'
            	            {
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:398:7: ()
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:399:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleAddition875); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:408:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:409:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:409:1: (lv_right_5_0= ruleMultiplication )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:410:3: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition898);
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:434:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:435:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:436:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication936);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication946); if (state.failed) return current;

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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:443:1: ruleMultiplication returns [EObject current=null] : (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Prefixed_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:446:28: ( (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:447:1: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:447:1: (this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )* )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:448:5: this_Prefixed_0= rulePrefixed ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getPrefixedParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrefixed_in_ruleMultiplication993);
            this_Prefixed_0=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Prefixed_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:1: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=18 && LA9_0<=19)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:2: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= rulePrefixed ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:2: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:3: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:456:3: ()
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:457:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicationAccess().getMultiOrDivLeftAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:462:2: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:463:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:463:1: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:464:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:464:1: (lv_op_2_1= '*' | lv_op_2_2= '/' )
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:465:3: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,18,FOLLOW_18_in_ruleMultiplication1023); if (state.failed) return current;
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
            	            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:477:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,19,FOLLOW_19_in_ruleMultiplication1052); if (state.failed) return current;
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

            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:492:3: ( (lv_right_3_0= rulePrefixed ) )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:493:1: (lv_right_3_0= rulePrefixed )
            	    {
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:493:1: (lv_right_3_0= rulePrefixed )
            	    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:494:3: lv_right_3_0= rulePrefixed
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightPrefixedParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrefixed_in_ruleMultiplication1090);
            	    lv_right_3_0=rulePrefixed();

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
            	              		"Prefixed");
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRulePrefixed"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:518:1: entryRulePrefixed returns [EObject current=null] : iv_rulePrefixed= rulePrefixed EOF ;
    public final EObject entryRulePrefixed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixed = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:519:2: (iv_rulePrefixed= rulePrefixed EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:520:2: iv_rulePrefixed= rulePrefixed EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedRule()); 
            }
            pushFollow(FOLLOW_rulePrefixed_in_entryRulePrefixed1128);
            iv_rulePrefixed=rulePrefixed();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixed; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixed1138); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrefixed"


    // $ANTLR start "rulePrefixed"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:527:1: rulePrefixed returns [EObject current=null] : ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) ;
    public final EObject rulePrefixed() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;

        EObject lv_expression_5_0 = null;

        EObject this_Atomic_6 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:530:28: ( ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:1: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:1: ( ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) ) | ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) ) | this_Atomic_6= ruleAtomic )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt10=1;
                }
                break;
            case 17:
                {
                alt10=2;
                }
                break;
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 21:
            case 23:
            case 24:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:2: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:2: ( () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:3: () ( ( '!' )=>otherlv_1= '!' ) ( (lv_expression_2_0= ruleAtomic ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:531:3: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:532:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedAccess().getBooleanNegationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:537:2: ( ( '!' )=>otherlv_1= '!' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:537:3: ( '!' )=>otherlv_1= '!'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_rulePrefixed1193); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrefixedAccess().getExclamationMarkKeyword_0_1());
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:542:2: ( (lv_expression_2_0= ruleAtomic ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:543:1: (lv_expression_2_0= ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:543:1: (lv_expression_2_0= ruleAtomic )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:544:3: lv_expression_2_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rulePrefixed1215);
                    lv_expression_2_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"Atomic");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:6: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:6: ( () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:7: () ( ( '-' )=>otherlv_4= '-' ) ( (lv_expression_5_0= ruleAtomic ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:561:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:562:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedAccess().getArithmeticSignedAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:567:2: ( ( '-' )=>otherlv_4= '-' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:567:3: ( '-' )=>otherlv_4= '-'
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_17_in_rulePrefixed1252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPrefixedAccess().getHyphenMinusKeyword_1_1());
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:572:2: ( (lv_expression_5_0= ruleAtomic ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:573:1: (lv_expression_5_0= ruleAtomic )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:573:1: (lv_expression_5_0= ruleAtomic )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:574:3: lv_expression_5_0= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedAccess().getExpressionAtomicParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rulePrefixed1274);
                    lv_expression_5_0=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedRule());
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
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:592:5: this_Atomic_6= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedAccess().getAtomicParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAtomic_in_rulePrefixed1303);
                    this_Atomic_6=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Atomic_6; 
                              afterParserOrEnumRuleCall();
                          
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
    // $ANTLR end "rulePrefixed"


    // $ANTLR start "entryRuleAtomic"
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:608:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:609:2: (iv_ruleAtomic= ruleAtomic EOF )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:610:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_ruleAtomic_in_entryRuleAtomic1338);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomic1348); if (state.failed) return current;

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
    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:617:1: ruleAtomic returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Token lv_value_6_0=null;
        Token lv_value_8_1=null;
        Token lv_value_8_2=null;
        Token otherlv_10=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:620:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ) ) )
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:621:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ) )
            {
            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:621:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_INT ) ) ) | ( () ( (lv_value_6_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) ) | ( () ( (otherlv_10= RULE_ID ) ) ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt12=1;
                }
                break;
            case RULE_INT:
                {
                alt12=2;
                }
                break;
            case RULE_STRING:
                {
                alt12=3;
                }
                break;
            case 23:
            case 24:
                {
                alt12=4;
                }
                break;
            case RULE_ID:
                {
                alt12=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:621:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:621:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:621:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleAtomic1386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleAtomic1408);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleAtomic1419); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:639:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:639:6: ( () ( (lv_value_4_0= RULE_INT ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:639:7: () ( (lv_value_4_0= RULE_INT ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:639:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:640:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getNumberLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:645:2: ( (lv_value_4_0= RULE_INT ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:646:1: (lv_value_4_0= RULE_INT )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:646:1: (lv_value_4_0= RULE_INT )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:647:3: lv_value_4_0= RULE_INT
                    {
                    lv_value_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAtomic1453); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_4_0, grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_4_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:664:6: ( () ( (lv_value_6_0= RULE_STRING ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:664:6: ( () ( (lv_value_6_0= RULE_STRING ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:664:7: () ( (lv_value_6_0= RULE_STRING ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:664:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:665:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getStringLiteralAction_2_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:670:2: ( (lv_value_6_0= RULE_STRING ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:671:1: (lv_value_6_0= RULE_STRING )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:671:1: (lv_value_6_0= RULE_STRING )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:672:3: lv_value_6_0= RULE_STRING
                    {
                    lv_value_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAtomic1492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_6_0, grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:689:6: ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:689:6: ( () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:689:7: () ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:689:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:690:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getBooleanLiteralAction_3_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:695:2: ( ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:1: ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:696:1: ( (lv_value_8_1= 'true' | lv_value_8_2= 'false' ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:697:1: (lv_value_8_1= 'true' | lv_value_8_2= 'false' )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:697:1: (lv_value_8_1= 'true' | lv_value_8_2= 'false' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==23) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==24) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:698:3: lv_value_8_1= 'true'
                            {
                            lv_value_8_1=(Token)match(input,23,FOLLOW_23_in_ruleAtomic1534); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_value_8_1, grammarAccess.getAtomicAccess().getValueTrueKeyword_3_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicRule());
                              	        }
                                     		setWithLastConsumed(current, "value", lv_value_8_1, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:710:8: lv_value_8_2= 'false'
                            {
                            lv_value_8_2=(Token)match(input,24,FOLLOW_24_in_ruleAtomic1563); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_value_8_2, grammarAccess.getAtomicAccess().getValueFalseKeyword_3_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAtomicRule());
                              	        }
                                     		setWithLastConsumed(current, "value", lv_value_8_2, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:726:6: ( () ( (otherlv_10= RULE_ID ) ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:726:6: ( () ( (otherlv_10= RULE_ID ) ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:726:7: () ( (otherlv_10= RULE_ID ) )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:726:7: ()
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:727:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAtomicAccess().getVariableReferenceAction_4_0(),
                                  current);
                          
                    }

                    }

                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:732:2: ( (otherlv_10= RULE_ID ) )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:733:1: (otherlv_10= RULE_ID )
                    {
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:733:1: (otherlv_10= RULE_ID )
                    // ../it.xsemantics.example.expressions/src-gen/it/xsemantics/example/expressions/parser/antlr/internal/InternalExpressions.g:734:3: otherlv_10= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAtomicRule());
                      	        }
                              
                    }
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtomic1616); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_10, grammarAccess.getAtomicAccess().getRefVariableCrossReference_4_1_0()); 
                      	
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
    public static final BitSet FOLLOW_11_in_ruleVariable235 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariable256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_ruleExpression348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleBooleanExpression439 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_12_in_ruleBooleanExpression469 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_13_in_ruleBooleanExpression498 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleBooleanExpression536 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison631 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_14_in_ruleComparison661 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_15_in_ruleComparison690 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison728 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition823 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_16_in_ruleAddition846 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_17_in_ruleAddition875 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition898 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixed_in_ruleMultiplication993 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_18_in_ruleMultiplication1023 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_19_in_ruleMultiplication1052 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_rulePrefixed_in_ruleMultiplication1090 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_rulePrefixed_in_entryRulePrefixed1128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixed1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rulePrefixed1193 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleAtomic_in_rulePrefixed1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rulePrefixed1252 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleAtomic_in_rulePrefixed1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_rulePrefixed1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomic_in_entryRuleAtomic1338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomic1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAtomic1386 = new BitSet(new long[]{0x0000000001B20070L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAtomic1408 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAtomic1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAtomic1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAtomic1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleAtomic1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAtomic1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtomic1616 = new BitSet(new long[]{0x0000000000000002L});

}